import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9771 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toLowerCase(); // 입력 단어 소문자로 통일
        int wordCount = 0;
        String line;

        while ((line = br.readLine()) != null) { // EOF 처리
            String[] tokens = line.split("\\s+");
            for (String token : tokens) {
                if (token.contains(word)) {
                    wordCount++;
                }
            }
        }

        System.out.println(wordCount);
    }
}
