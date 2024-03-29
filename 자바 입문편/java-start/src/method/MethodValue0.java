package method;

public class MethodValue0 {

    public static void main(String[] args) {
        int num1 = 5;
        int num2 = num1;
        num2 = 10;

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

    }
}


/*
!!!!!!!!자바의 대원칙!!!!!!!!!!!!!!
<<자바는 항상 변수의 값을 복사해서 대입함>>
int num1=5;
int num2=num1;
 _> num1의 값을 복사해서 num2에 저장함.

참조형은 참조값을 복사하는 것
 */