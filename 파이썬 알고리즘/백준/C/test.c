#include <stdio.h>
#include "linetable.h"
#include <string.h>
#include <stdlib.h>

#define MAXLINE 1024
#define MAXLENGTH 1000

LineTable lines[MAXLENGTH];

void index_file(FILE *fp){
    int total_lines = 0;
    char buffer[MAXLINE];

    while(fgets(buffer, MAXLINE, fp) != NULL){
        lines[total_lines].id = total_lines + 1;
        lines[total_lines].line_start = ftell(fp);
        lines[total_lines].line_length = strlen(buffer);
        total_lines++;
    }
}

void print_line(FILE *fp, int line_number){
    char buffer[MAXLINE];
    size_t length = fread(buffer, 1, lines[line_number - 1].line_length, fp);
    buffer[length] = '\0';
    printf("%d: %s", line_number, buffer);
}

int main(int argc, char *argv[]){
    if (argc < 2){
        fprintf(stderr, "Error");
        return 1;
    }

    FILE *fp;
    if(!fp){
        perror("Error");
        return 1;
    }
    index_file(fp);
    char input[MAXLINE];
    while(1) {
        fgets(input, MAXLINE, stdin);
        input[strcspn(input, "\n")] = 0;

        if (strcmp(input, "q") == 0){
            break;
        }

        if (strcmp(input, "*") == 0){
            rewind(fp);
            char buffer[MAXLINE];
            int line_number = 0;
            while(fgets(buffer, MAXLINE, fp) != NULL){
                print_line(fp, line_number);
            }
        } else {
            char *token = strtok(input, ",");
            while(token) {
                if (strchr(token, "-")){
                    int start, end;
                    sscanf(token, "%d-%d", &start, &end);
                    for(int i = start; i <= end; i++){
                        print_line(fp, i);
                    }
                } else {
                    int line_num = atoi(token);
                    print_line(fp, line_num);
                }
                token = strtok(NULL, ",");
            }
        }
    }
    fclose(fp);
    return 0;
}