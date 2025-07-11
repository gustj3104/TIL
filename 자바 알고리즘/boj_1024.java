import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1024{

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    for (int i = L; i <= 100; i++) {
      int tmp = N - (i * (i - 1)) / 2;
      if (tmp < 0) break;
      if (tmp % i == 0) {
        int x = tmp / i;
        if (x >= 0) {
          for (int j = 0; j < i; j++) {
            System.out.print(x + " ");
            x++;
          }
          System.exit(0);
        }
      }
    }
    System.out.println(-1);
  }
}
