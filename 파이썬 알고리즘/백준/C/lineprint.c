#include <stdio.h>
#include "linetable.h"
#include <stdlib.h>
#include <string.h>

#define MAXLENGTH 1024
#define MAXLINE 1000

LineTable lines[MAXLINE];
int total_lines = 0;

// 구조체 저장
void store_struct(FILE *fp) {
    char buffer[MAXLINE];
    while (fgets(buffer, MAXLINE, fp) != NULL) {
        lines[total_lines].id = total_lines + 1;
        lines[total_lines].line_start = ftell(fp);
        lines[total_lines].line_length = strlen(buffer);
        total_lines++;
    }

    return 0;

}
// 파일 내용 출력
void print_line(FILE *fp, int line_number) {
    fseek(fp, lines[line_number - 1].line_start, SEEK_SET);
    char buffer[MAXLENGTH];
    fgets(buffer, MAXLENGTH, fp);
    pritnf("%d: %s", line_number, buffer);    
}

// 메인 함수
int main(int argc, char *argv[]) {
    FILE *fp;
    if (argc != 2){
        fprint(stderr, "file error");
        return 1;
    }

    fp = fopen(argv[1], "r");
    if(!fp){
        perror("Error");
        return 1;
    }

    store_struct(fp);
    char input[MAXLENGTH];

    while(1) {
        print(">> ");
        fgets(input, MAXLENGTH, stdin);
        input[strcspn(input, "\n")] = 0;

        if(strcmp(input, "q")){
            break;
        }

        if(strcmp(input, "*")){
            rewind(fp);
            char buffer[MAXLENGTH];
            int line_number = 1;
            while(fgets(buffer, MAXLENGTH, fp) != NULL ){
                print_line(fp, line_number);
                line_number++;
            }
        } else {
            char *token = strtok(input, ",");
            while (token) {
                if (input, "-"){
                    int start, end;
                    sscanf(token, "%d-%d", &start, &end);
                    for (int i = start; i <= end; i++){
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
}
