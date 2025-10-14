package mid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InsertingOperators {

    /**
     * base case
     *
     *
     * recurrence relation
     * i번쨰에 덧셈을 넣는 경우
     * 뺄셈을 넣는 경우
     * 아무것도 넣지 않는 경우
     *
     * 종료 조건
     * i = n - 1 -> 모든 연산자가 다 들어간 경우
     *
     * 마지막 숫자를 바로 더하거나 빼지 않고 조회만 해놓음
     * ex) 1 2 3 4 -> 1 - 2 3 4 라면 1- 2일지 1 - 23일지 결정되어있지가 않음
     *
     * 현재 연산자가 없는 경우
     * 앞에 *10 하고 뒤에 붙여줌
     *
     * 더하기인 경우 현재 숫자를 더해줌
     * 뺼셈인 경우 현재 숫자를 빼줌
     *
     */

    public static int countopers(int n, int i, int[] opers, int T) {
        // i : 앞에서 사용한 연산자 수
        if (n - 1 == i) {
            int res = 0; // 총 개수
            int curnum = 1; // 맨 마지막에 연산하게 될 숫자(바로 더하거나 뺴지 않음)
            int curop = 1; // 현재 연산자

            for (int j = 0; j < ; j++) {

            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] opers = new int[n-1]; //  -: 뺄셈, +: 덧셈
            int T = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++) {
                opers[j] = j + 1;
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
