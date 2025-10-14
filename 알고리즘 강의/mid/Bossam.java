package mid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bossam {
    public static int binarysearch(int[] m, int n, int maxdes, int total) {
        int l = 1;
        int h = maxdes;

        while(l <= h) {
            int mid = (h + l) / 2; // mid: 현재 시점의 상한선
            int pieces = 0; // 실제로 배식된 보쌈 수
            for (int i = 0; i < n; i++) {
                if (mid > m[i]) pieces += m[i];
                else pieces += mid; // 상한선보다 더 원해도 상한선까지만 배식
                if (pieces > total) h = mid - 1;
                else l = mid + 1;
            }
        }

        return h;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine()); // 사람 수
            int[] m =  new int[n];// 각자 원하는 배식량
            StringTokenizer st = new StringTokenizer(br.readLine());
            int min = 100000;
            int max = 0;

            for (int j = 0; j < n; j++) {
                m[j] = Integer.parseInt(st.nextToken());
                if(m[j] < min){
                    min = m[j];
                } else if(m[j] > max){
                    max = m[j];
                }
            }

            int total = Integer.parseInt(br.readLine());

            // Arrays.sort(m);
            System.out.println(binarysearch(m, n, max, total));

        }
    }
}

/**
 * 배식제한의 상한선 구하기
 * 1-13 사이 이진탐색으로 mid 를 구하는 알고리즘
 */