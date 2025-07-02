import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2783 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int g = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(br.readLine());
    double minPrice = (double) n / g * 1000;

    for (int i = 1; i < t + 1; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      n = Integer.parseInt(st.nextToken());
      g = Integer.parseInt(st.nextToken());
      double price = (double) n / g * 1000;
      minPrice = Math.min(minPrice, price);
    }

    System.out.printf("%.2f\n", minPrice);

  }

}

/*
삼각 김밥 Y 그램 당 X 원 >> 1000그램 구매
 */