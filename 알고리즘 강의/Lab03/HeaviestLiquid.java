package Lab03;

import java.io.*;
import java.util.*;

public class HeaviestLiquid {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine()); // liquid 개수
            int[] v = new int[n];
            int[] w = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) v[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) w[i] = Integer.parseInt(st.nextToken());

            long p = Long.parseLong(br.readLine()); // 플라스크 용량 (long으로 변경)

            // 밀도 배열 생성
            double[][] liquid = new double[n][3]; // 0: v, 1: w, 2: w/v
            for (int i = 0; i < n; i++) {
                liquid[i][0] = v[i];
                liquid[i][1] = w[i];
                liquid[i][2] = (double) w[i] / v[i];
            }

            // 밀도 내림차순 정렬
            Arrays.sort(liquid, (a, b) -> Double.compare(b[2], a[2]));

            double total = 0;
            for (int i = 0; i < n && p > 0; i++) {
                if (p >= liquid[i][0]) { // 전부 담을 수 있으면
                    total += liquid[i][1];
                    p -= (long) liquid[i][0];
                } else { // 일부만 담을 수 있음
                    total += p * liquid[i][2];
                    p = 0;
                }
            }

            // 정수부만 출력
            sb.append((long) total).append('\n');
        }
        System.out.print(sb);
    }
}
