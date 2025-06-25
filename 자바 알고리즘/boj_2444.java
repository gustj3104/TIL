import java.util.Scanner;

public class boj_2444 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    // 윗부분
    for (int i = 1; i <= n; i++) {
      String blank = " ".repeat(n - i);
      String star = "*".repeat(2 * i - 1);
      System.out.println(blank + star);
    }

    // 아랫부분
    for (int i = n - 1; i >= 1; i--) {
      String blank = " ".repeat(n - i);
      String star = "*".repeat(2 * i - 1);
      System.out.println(blank + star);
    }
  }
}
