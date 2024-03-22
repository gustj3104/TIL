package scanner.ex;

import java.util.Scanner;

public class ScannerWhileEx4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        int totalPrice = 0;

        System.out.println("1: 상품 입력, 2: 결제, 3: 프로그램 종료");
        while ((option = scanner.nextInt()) != 3) {
            scanner.nextLine();

            if (option == 1) {
                System.out.print("상품명을 입력하세요: ");
                String item = scanner.nextLine();

                System.out.print("상품의 가격을 입력하세요: ");
                int itemPrice = scanner.nextInt();

                System.out.print("구매 수량을 입력하세요: ");
                int itemQuatity = scanner.nextInt();

                System.out.println("상품명: " + item + ", 가격: " + itemPrice + ", 수량: " + itemQuatity + ", 합계: " + itemPrice * itemQuatity);
                totalPrice += itemPrice * itemQuatity;
                System.out.println("1: 상품 입력, 2: 결제, 3: 프로그램 종료");

            } else if (option == 2) {
                System.out.println("총 비용: " + totalPrice);
                totalPrice = 0;
                System.out.println("1: 상품 입력, 2: 결제, 3: 프로그램 종료");
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }
}
