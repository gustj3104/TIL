import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2903 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int side = (1 << N) + 1;
    int result = side * side;
    System.out.println(result);
  }
}

