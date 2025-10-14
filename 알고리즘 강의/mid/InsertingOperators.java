package mid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InsertingOperators {

    public static int isTarget() {

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] numbers = new int[n];
            int target = Integer.parseInt(st.nextToken());
            int count = 0;
            int total = 0;

            for (int j = 0; j < n; j++) {
                numbers[j] = j + 1;
            }

            for (int j = 0; j < n; j++) {
                if (numbers[j] == target) {
                    count++;
                }

                int temp = total*10 + numbers[j];
                if (temp > target) {
                    continue;
                } else if (temp == target) {
                    count++;
                }

                int minusTemp = total * 10 - numbers[j];
                if (temp > target) {
                    continue;
                } else if (temp == target) {
                    count++;
                }




            }
        }
    }
}

/**
 * 숫자 사이에 +, - 를 삽입해서 목표 t를 만들 수 있는 경우의 수
 * n이 작은 수로 제공됨 -> backtracking
 * 앞의 수에 * 10 + 현재 수 == t이면 count
 *  크면 prune, - 삽입 -> 앞의 수 * 10 - 현재 수 == t?
 */
