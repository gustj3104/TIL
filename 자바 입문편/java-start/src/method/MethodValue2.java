package method;

public class MethodValue2 {

    public static void main(String[] args) {
        int number = 5;
        System.out.println("1. changNumber 호출 전, num1: " + number);
        changeNumber(number);
        System.out.println("4. changeNumber 호출 후, num1: " + number);
    }

    public static void changeNumber(int number) {
        System.out.println("2. changeNumber 변경 전, num2: " + number);
        number = number * 2;
        System.out.println("3. changeNumbber 변경 후, num2: " + number);
    }
}
/*
변수명이 같아도 똑같이 main의 변수, 전달된 변수는 서로 영향이 없음.
main()도 메서드임. 각각의 메서드 안에서 사용하는 변수는 서로 완전히 분리된 다른 변수임. == main()의  number와 changeNumber의 number는 서로 다른 변수

 */