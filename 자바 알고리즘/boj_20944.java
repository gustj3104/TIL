import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_20944 {

  public static void main(String[] args) throws IOException {
    // 수미상관이면서 팰린드롬인 문자열
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append('a');
    }

    System.out.println(sb.toString());

  }
}
