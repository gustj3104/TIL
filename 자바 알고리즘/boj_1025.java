import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 [2025-09-29] 백준 1025번(https://www.acmicpc.net/problem/1025)

 문제 : 등차수열을 이루는 행의 번호와 열의 번호를 선택하여 선택한 칸에 적힌 수를 순서대로 이어붙이면 정수를 만들 수 있다.
        만들 수 있는 정수 중 가장 큰 완전 제곱수 구하기
 Cf. 완전 제곱수 : 어떤 정수를 제곱한 수

 입력 : 행의 수 N, 열의 수 M / N x M 개의 숫자
 출력 : 가장 큰 완전 제곱수, 없으면 -1
 */

public class boj_1025 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 행의 수
    int M = Integer.parseInt(st.nextToken()); // 열의 수
    int[][] field = new int[N][M]; // N x M 크기 필드

    for (int i = 0; i < N; i++) {
      String l = br.readLine().trim();
      for (int j = 0; j < M; j++) {
        field[i][j] = l.charAt(j) - '0';
      }
    }

    long answer = -1;
    for (int r = 0; r < N; r++) {
      for (int c = 0; c < M; c++) {
        // dr: 열 기준 증분, dc: 행 기준 증분
        for (int dr = -N; dr <= N; dr++) {
          for (int dc = -M; dc <= M; dc++) {
            if(dc == 0 && dr == 0) continue; // 둘 다 0이면 이동X

            // 초기값 저장
            int nr = r;
            int nc = c;
            long num = 0;

            // field 범위 내 요소인 동안 반복
            while (0 <= nr && nr < N && 0 <= nc && nc < M) {
              // 원래값 자릿수 하나 올리고 일의 자리에 숫자 붙이기
              num = num * 10 + field[nr][nc];
              if(num < 0) return;

              // 완전 제곱수 판별
              if (num >= 0) {
                long s = (long) Math.sqrt(num);
                if (s * s == num) {
                  answer = Math.max(answer, num); // answer 갱신
                }
              }
              // 증분을 반영한 다음 위치의 요소 읽어옴
              nr += dr;
              nc += dc;
            }
          }
        }
      }
    }
    System.out.println(answer);
  }
}
