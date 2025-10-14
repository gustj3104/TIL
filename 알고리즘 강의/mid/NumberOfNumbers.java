/*
package mid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class NumberOfNumbers {

    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // L 길이
            int M = Integer.parseInt(st.nextToken()); // Q 길이
            int[] L = new int[N];
            int[] Q = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                L[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                Q[i] = Integer.parseInt(st.nextToken());
            }

            count = 0; // q의 개수
            Arrays.sort(L);
            int[] frontL = new int[N / 2];
            int[] backL = new int[N / 2];

            for (int i = 0; i < N; i++) {
                frontL[i] = L[i];
                backL[i] = L[N - i - 1];
            }

            for (int q : Q) {
                findQ(q, frontL);
                findQ(q, backL)
            }

        }
    }

    static int findQ(int[] sortedL, int q){

    }
}

*/
/**
L에서 Q 찾기
 L -> sort -> binary search

 */
