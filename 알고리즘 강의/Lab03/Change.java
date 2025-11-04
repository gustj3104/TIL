package Lab03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Change {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] moneyList = {50000, 10000, 5000, 1000};

        while (t-- > 0) {
            int target = Integer.parseInt(br.readLine());
            int count = 0;
            while (true) {
                for (int i = 0; i < 4; i++) {
                    while (target - moneyList[i] >= 0) {
                        count += 1;
                        target -= moneyList[i];
                    }
                }
                if (target == 0) {
                    break;
                } else {
                    count += 1;
                    break;
                }
            }
            System.out.println(count);
        }
    }
}