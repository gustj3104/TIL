package Lab02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] L = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                L[i] = Integer.parseInt(st.nextToken());
            }

            int[] LIS =  new int[n];
            int max = 1;
            LIS[0] = 1;
            for (int i = 1; i < n; i++) {
                LIS[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (L[i] > L[j]) {
                        int m = Math.max(LIS[i], LIS[j] + 1);
                        LIS[i] = m;
                        max = Math.max(max, m);
                    }
                }
            }
            System.out.println(max);

        }
    }
}


/**
 * 이전 요소보다 크면 해당 요소의 LIS + 1로 저장
 *
 */