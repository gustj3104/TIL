import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9093 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      String[] words = br.readLine().split(" ");
      StringBuilder lineBuilder = new StringBuilder();

      for (int i = 0; i < words.length; i++) {
        String reversed = new StringBuilder(words[i]).reverse().toString();
        lineBuilder.append(reversed);

        if (i < words.length - 1) {
          lineBuilder.append(" ");
        }
      }

      System.out.println(lineBuilder.toString());

    }
  }

}
