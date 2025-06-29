import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_5554 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int time = 0;
    for (int i = 0; i < 4; i++) {
      int t = Integer.parseInt(br.readLine());
      time += t;
    }

    System.out.println(time / 60);
    System.out.println(time % 60);

  }

}
