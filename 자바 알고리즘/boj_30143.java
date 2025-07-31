import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_30143 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int N = Integer.parseInt(st.nextToken());
      int A = Integer.parseInt(st.nextToken());
      int D = Integer.parseInt(st.nextToken());

      int sum = 0;
      int cur = A;
      for (int j = 0; j < N; j++) {
        sum += cur;
        cur += D;
      }
      System.out.println(sum);
    }
  }
}

/*
N: 등차수열 원소의 총 개수
A: 등차수열의 초항
D: 등차수열의 등차
-> N A D가 주어질 때 등차수열의 합을 구하시오
 */