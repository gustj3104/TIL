import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_16017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[4];
        for (int i = 0; i < 4; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        if ((num[0] == 8 || num[0] == 9) && (num[1] == num[2]) && (num[3] == 8 || num[3] == 9)) {
            System.out.println("ignore");
        } else {
            System.out.println("answer");
        }
    }
}

/*
네 자리 중 첫 번째 자리가 8 또는 9
마지막 자리가 8 또는 9
두 번째, 세 번째 자리가 같으면 스팸
 */
