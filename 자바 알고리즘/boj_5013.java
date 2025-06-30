import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_5013 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int win = n;
    for (int i = 0; i < n; i++) {
      if (br.readLine().contains("CD")) {
        win--;
      }
    }
    System.out.println(win);
  }
}
