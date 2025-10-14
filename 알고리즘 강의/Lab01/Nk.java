package Lab01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Nk {
    public static int OP = 25919;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] num = br.readLine().split(" ");
            int n = Integer.parseInt(num[0]);
            int k = Integer.parseInt(num[1]);

            System.out.println(countN(n, k));
        }
    }

    public static int countN(int n, int k) {
        if (k == 0) {
            return 1;
        }

        long next = countN(n, k / 2);
        long result = next * next % OP;

        if (k % 2 == 1) {
            result = (result * n) % OP;
        }

        return (int) result;
    }
}