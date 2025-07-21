import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_26535 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    int min_square = 0;
    for (int i = 1; i <= n; i++) {
      if (i * i >= n) {
        min_square = i;
        break;
      }
    }

    String result = "x".repeat(min_square + 2);
    sb.append(result + "\n");
    for (int i = 0; i < min_square; i++) {
      sb.append("x" + ".".repeat(min_square) + "x\n");
    }
    sb.append(result + "\n");

    System.out.println(sb.toString());
  }

}
