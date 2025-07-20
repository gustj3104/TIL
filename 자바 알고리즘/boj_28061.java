import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_28061 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int max = 0;
    for (int i = 0; i < N; i++) {
      int lemon = Integer.parseInt(st.nextToken()) - (N - i);
      if (lemon > max) {
        max = lemon;
      }
    }
    System.out.println(max);
  }

}

/*
나무 N그루가 x = 1 ~ N까지 일정한 간격으로 자람
성우는 x = 0에 위치, 집은 x = N + 1
x = i 위치의 나무는 레몬이 a_i개 자람
이동 시 레몬이 1개씩 떨어짐 -> 집에 가져갈 수 있는 최대 레몬 개수
 */