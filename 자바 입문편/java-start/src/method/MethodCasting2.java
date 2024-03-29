package method;

public class MethodCasting2 {

    public static void main(String[] args) {
        int number = 100;
        printNumber(number);//double형 매개변수에 int형을 전달하는 건 문제 없음(자동 형변환)
    }

    public static void printNumber(double n) {
        System.out.println("숫자: " + n);
    }
}
