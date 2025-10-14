package mid_result;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class NumberOfNumbers {
    public static int binarysearchfirst(int[] L, int n, int q) {
        int l = 0;
        int h = n - 1;
        while (l <= h) {
            int mid = (l + h) / 2;

            // q 중 가장 작은 것 -> 앞쪽으로 봐야됨
                // 같을 때, q가 더 작을 때 앞단 & 다른 경우는 뒷단
            if (L[mid] >= q) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return L[l];
    }

    public static int binarysearchlast(int[] L, int n, int q) {
        int l = 0;
        int h = n - 1;
        while (l <= h) {
            int mid = (l + h) / 2;

            // q 중 가장 큰 것 -> 뒷쪽으로 봐야됨
            // 더 작을 때만 앞단을 보고 다른 경우 뒷단
            if (L[mid] > q) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return L[h];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int L[] = new int[n];
            int m = sc.nextInt();
            for (int j = 0; j < n; j++) {
                L[j] = sc.nextInt();
            }
            Arrays.sort(L);

            for (int j = 0; j < m; j++) {
                int q =  sc.nextInt();
                System.out.print(binarysearchlast(L, n, q) - binarysearchfirst(L, n, q) + 1);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

// q+1의 이전 인덱스 - q의 시작 인덱스 + 1로도 계산할 수 있음
