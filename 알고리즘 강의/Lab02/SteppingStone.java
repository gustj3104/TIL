package Lab02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SteppingStone {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                if(i - 1 >= 0) dp[i] = (dp[i] + dp[i - 1]) % 25919;
                if(i - 3 >= 0) dp[i] = (dp[i] + dp[i - 3]) % 25919;
                if(i - 4 >= 0) dp[i] = (dp[i] + dp[i - 4]) % 25919;
            }

            System.out.println(dp[n]);
        }
    }
}
