import java.util.Scanner;

public class boj_32154 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    String[][] board = {{"11", "A B C D E F G H J L M"},
        {"9", "A C E F G H I L M"},
        {"9", "A C E F G H I L M"},
        {"9", "A B C E F G H L M"},
        {"8", "A C E F G H L M"},
        {"8", "A C E F G H L M"},
        {"8", "A C E F G H L M"},
        {"8", "A C E F G H L M"},
        {"8", "A C E F G H L M"},
        {"8", "A B C F G H L M"}};

    System.out.println(board[n - 1][0] + "\n" + board[n - 1][1]);
  }
}
