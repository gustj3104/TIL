import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_31495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] word = s.toCharArray();
        if (word[0] == '"' && word[word.length - 1] == '"') {
            System.out.println(s.substring(1, s.length()-1));
        } else {
            System.out.println("CE");
        }
    }
}
