import java.util.ArrayList;
import java.util.Scanner;

public class boj_15633 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int sqrt = (int) Math.sqrt(n);
    ArrayList<Integer> arr = new ArrayList<>();

    for (int i = 1; i <= sqrt; i++) {
      if (n % i == 0) {
        arr.add(i);
        if (n / i != i) {
          arr.add(n / i);
        }
      }
    }
    int sum = 0;
    for (int i : arr) {
      sum += i;
    }

    System.out.println(sum * 5 - 24);
  }

}

/*
자연수 n이 주어졌을 때 n의 모든 약수의 합 구하기
구한 값에 5 곱하고 24를 빼서 출력하기
 */