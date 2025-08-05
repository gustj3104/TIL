import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14656 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int result = 0;
    for (int i = 1; i <= N; i++) {
      int cur = Integer.parseInt(st.nextToken());
      if (cur != i) {
        result++;
      }
    }

    System.out.println(result);
  }

}

