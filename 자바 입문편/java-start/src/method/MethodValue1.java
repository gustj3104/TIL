package method;

public class MethodValue1 {

    public static void main(String[] args) {
        int num1 = 5;
        System.out.println("1. changNumber 호출 전, num1: " + num1);
        changeNumber(num1);
        System.out.println("4. changeNumber 호출 후, num1: " + num1);
    }

    public static void changeNumber(int num2) {
        System.out.println("2. changeNumber 변경 전, num2: " + num2);
        num2 = num2 * 2;
        System.out.println("3. changeNumbber 변경 후, num2: " + num2);
    }
}
/*
num1=5 -> num2=5로 복사
num2=num*2 -> 복사된 num2=10저장
num1에는 아무 영향이 없음.
 */