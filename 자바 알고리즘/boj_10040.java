import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10040 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] nm = br.readLine().split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);

    int[] cost = new int[n];
    for (int i = 0; i < n; i++) {
      cost[i] = Integer.parseInt(br.readLine());
    }

    int[] vote = new int[n];
    for (int i = 0; i < m; i++) {
      int b = Integer.parseInt(br.readLine());
      for (int j = 0; j < n; j++) {
        if (cost[j] <= b) {
          vote[j]++;
          break;
        }
      }
    }

    int max = 0;
    int result = 0;
    for (int i = 0; i < n; i++) {
      if (vote[i] > max) {
        max = vote[i];
        result = i;
      }
    }

    System.out.println(result + 1);

  }
}


/*
후보 종목 N개를 재미있는 순서대로 나열한 리스트
-> i번째 종목 = i번째로 재미있는 종목 -> 개최 비용 = A_i

조직위원회는 M명으로 구성(1~M번 위원)
-> j 위원은 B_j 기준으로 개최 비용이 B_j가 넘지않는 경기중 가장 재미있는 경기에 표

가장 많은 표를 획득한 경기 번호 출력하기
 */