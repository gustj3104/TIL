import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2729 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int time = Integer.parseInt(st.nextToken());
    int drink = Integer.parseInt(st.nextToken());

    if (time >= 12 && time <= 16 && drink == 0) {
      // 점심시간
        System.out.println(320);
        return;
    }

    System.out.println(280);
  }
}
