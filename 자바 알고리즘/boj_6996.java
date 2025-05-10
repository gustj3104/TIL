import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_6996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String first = st.nextToken();
            String second = st.nextToken();

            // 문자대로 정렬
            char[] a = first.toCharArray();
            char[] b = second.toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);

            // 애널그램 검사, 출력
            if (Arrays.equals(a, b)) {
                System.out.printf("%s & %s are anagrams.\n", first, second);
            } else {
                System.out.printf("%s & %s are NOT anagrams.\n", first, second);
            }
        }
    }
}
