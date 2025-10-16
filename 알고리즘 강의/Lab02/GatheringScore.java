package Lab02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GatheringScore {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[n][m];
            dp[0][0] = grid[0][0]; // 출발지

            // 첫행
            for (int i = 1; i < m; i++) {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }

            // 첫열
            for (int i = 1; i < n; i++) {
                dp[i][0] = dp[i-1][0] + grid[i][0];
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    int left = dp[i][j-1] + grid[i][j];
                    int bottom = dp[i-1][j] + grid[i][j];
                    dp[i][j] = Math.max(left, bottom);
                }
            }

            System.out.println(dp[n - 1][m - 1]);

        }
    }
}
