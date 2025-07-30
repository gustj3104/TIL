import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_33964 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());

    String x_repunit = "1".repeat(x);
    String y_repunit = "1".repeat(y);

    System.out.println(Integer.parseInt(x_repunit) + Integer.parseInt(y_repunit));

  }

}
