package scanner;

import java.util.Scanner;

public class Scanner1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //자바 라이브러리의 스캐너를 가져다 쓴다는 의미

        System.out.print("문자열을 입력하세요:");
        String str = scanner.nextLine(); //입력을 String으로 가져온다.
        System.out.println("입력한 문자열: " + str);

        System.out.print("정수를 입력히세요:");
        int intValue = scanner.nextInt();
        System.out.println("입력한 정수: " + intValue);

        System.out.print("실수를 입력하세요:");
        double doubleValue = scanner.nextDouble();
        System.out.println("입력한 실수: " + doubleValue);
    }
}

/*
    Scanner scanner = new Scanner(System.in);
    : Scanner의 기능을 사용하기 위해 new를 사용해 Scanner를 생성함.
    - Scanner는 System.in 을 사용해 사용자의 입력을 편리하게 받도록 도움.

    Scanner scanner은 scanner 변수를 선언함.

    scanner.nextLine()
    : \n이 입력할 때까지 문자를 가져옴.

   !-nextInt, nextDouble -> 타입이 다르면 오류가 발생하니 주의하자-!

 */