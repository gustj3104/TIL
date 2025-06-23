import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1049 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] price = new int[M][2];
    int minPackagePrice = 100000;
    int minPrice = 10000;
    for (int i = 0; i < M; i++) {
      String[] s = br.readLine().split(" ");
      price[i][0] = Integer.parseInt(s[0]); // 패키지
      price[i][1] = Integer.parseInt(s[1]); // 낱개
      if (price[i][0] < minPackagePrice) {
        minPackagePrice = price[i][0];
      }

      if (price[i][1] < minPrice) {
        minPrice = price[i][1];
      }
    }

    int option1 = minPackagePrice * (N / 6) + minPrice * (N % 6);
    int option2 = minPackagePrice * ((N / 6) + 1);
    int option3 = minPrice * N;
    System.out.println(Math.min(Math.min(option1, option2), option3));

  }

}

/*
기타의 N개의 줄이 끊어짐 -> 6줄 패키지/1개 또는 그 이상의 줄 낱개로 구매 가능
- 기타줄 N
- 기타줄 브랜드 M // 6줄 패키지, 낱개 가격
-> 필요한 돈의 수를 최소로 하는 프로그램

브랜드별 패키지/낱개 가격 이차원 배열

6줄 패키지 + 낱개
 */