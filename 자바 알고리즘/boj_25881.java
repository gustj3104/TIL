import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_25881 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] rate = br.readLine().split(" ");
    int base = Integer.parseInt(rate[0]);
    int extra = Integer.parseInt(rate[1]);

    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      int usage = Integer.parseInt(br.readLine());
      int cost = usage <= usage ? usage * base : (1000 * base) + (usage - 1000) * extra;
      System.out.printf("%d %d\n", usage, cost);
    }
  }
}

/*
기본 요금 : 1000KWH 요율
추가 사용 요금 : KWH당 요율
-> 고객의 에너지 소비량에 따른 요율 출력
 */