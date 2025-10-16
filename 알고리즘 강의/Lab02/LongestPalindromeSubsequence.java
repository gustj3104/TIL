package Lab02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalindromeSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String word = br.readLine();
            String[] s = new String[n];
            for (int i = 0; i < n; i++) {
                s[i] = String.valueOf(word.charAt(i));
            }
            
            int[][] LPS = new int[n][n];
            for (int i = 0; i < n; i++) {
                LPS[i][i] = 1;
            }

            for (int i = 0; i < n-1; i++) {
                if (s[i].equals(s[i + 1])) {
                    LPS[i][i + 1] = 2;
                } else {
                    LPS[i][i + 1] = 1;
                }
            }

            for (int i = n-3; i >= 0; i--) {
                for (int j = i + 2; j < n; j++) {
                    if (s[i].equals(s[j])) {
                        LPS[i][j] = Math.max(LPS[i + 1][j], LPS[i][j - 1]);
                        LPS[i][j] = Math.max(LPS[i][j], LPS[i + 1][j - 1] + 2);
                    } else {
                        LPS[i][j] = Math.max(LPS[i + 1][j], LPS[i][j - 1]);
                    }
                }
            }

            System.out.println(LPS[0][n-1]);

        }
    }
}
