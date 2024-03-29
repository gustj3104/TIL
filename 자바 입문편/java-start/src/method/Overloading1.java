package method;

public class Overloading1 {

    public static void main(String[] args) {
        System.out.println("1: " + add(1, 2));
        System.out.println("2: " + add(1, 2, 3));
    }

    public static int add(int a, int b) {
        System.out.println("1번 호출");
        return a + b;
    }

    public static int add(int a, int b, int c) {
        System.out.println("2번 호출");
        return a + b + c;
    }
}

/*
메서드 오버로딩
    : 이름이 같고 매개변수가 다른 메서드를 여러개 정의하는 것
    add(int a, int b)
    add(int a, int b, int c)
    add(double a, double b)
    - 메서드 이름이 같아도 매개변수의 타입 및 순서가 다르면 오버로딩을 할 수 있음. (반환 타입은 인정하지 않음)
    int add(int a, int b)
    double add(int a, int b) --> 오류 발생
    ++
    int add(int a, int b)
    int add(int c, int d) --> 이것도 오류 발생. 타입/개수가 달라야 함.

메서드 시그니처
    : 메서드 이름 + 매개변수 타입(순서)
    = 자바에서 메서드를 구분할 수 있는 고유한 식별자나 서명 [메서드를 구분할 수 있는 기준]
    - 메서드 이름이 같아도 메서드 시그니처가 다르면 다른 메서드로 간주함
 */