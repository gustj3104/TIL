import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_3778 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= n; tc++) {
            String a = br.readLine();
            String b = br.readLine();

            int[] count = new int[26]; // a ~ z

            for (char c : a.toCharArray()) count[c - 'a']++; //a에 대응되는 알파벳 개수 카운트
            for (char c : b.toCharArray()) count[c - 'a']--; // b에 대응되는 알파벳 개수 감소

            int total = 0;
            for (int diff : count) total += Math.abs(diff); //양수거나 음수가 되면 상쇄되지 못한 문자 -> 일치하지 않은 알파벳 수

            sb.append("Case #").append(tc).append(": ").append(total).append("\n");
        }
        System.out.print(sb);
    }
}
