import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_30156 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      char[] colors = br.readLine().toCharArray();
      int aCount = 0;
      int bCount = 0;
      for (char c : colors) {
        if (c == 'a') {
          aCount++;
        } else {
          bCount++;
        }
      }
      System.out.println(Math.min(aCount, bCount));
    }

  }

}
