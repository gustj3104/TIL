package Lab01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] nums = br.readLine().split(" ");
            int n = Integer.parseInt(nums[0]); // 리스트 L 길이
            int m = Integer.parseInt(nums[1]); // 리스트 Q 길이
            String[] list = br.readLine().split(" ");
            String[] qList = br.readLine().split(" ");
            int[] result = new int[m];

            for (int j = 0; j < m; j++) {
                result[j] = findQ(list, Integer.parseInt(qList[j]), 0);
            }

            for (int r : result) {
                System.out.print(r + " ");
            }
            System.out.println();
        }
    }

    public static int findQ(String[] list, int q, int i) {
        if (list.length == 0) return -1;

        int idx = list.length / 2;
        int mid = Integer.parseInt(list[idx]);

        if(mid == q) return idx + i;
        else if (mid > q) {
            String[] subList = Arrays.copyOfRange(list, 0, idx);
            return findQ(subList, q, i);
        } else {
            String[] subList = Arrays.copyOfRange(list, idx + 1, list.length);
            return findQ(subList, q, i + idx + 1);
        }
    }
}
