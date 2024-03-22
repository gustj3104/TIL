package scanner.ex;

import java.util.Scanner;

public class ScannerEx5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int firstNum = scanner.nextInt();

        System.out.print("두 번째 숫자를 입력하세요: ");
        int secondNum = scanner.nextInt();

        if (secondNum < firstNum) {
            int temp = firstNum;
            firstNum = secondNum;
            secondNum = temp;
        }

        System.out.print("두 숫자 사이의 모든 정수: ");
        for (int i = firstNum; i <= secondNum; i++) {
            System.out.print(i);
            if (i != secondNum) {
                System.out.print(", ");
            }
        }
    }
}
