package operator;

public class Operator1 {
    public static void main(String[] args) {
        int a = 5;
        int b = 2;

        //덧셈
        int sum = a + b;
        System.out.println("a + b = "+sum); //문자열 + 문자열 --> a+b=7

        //뺄셈
        int diff = a - b;
        System.out.println("a - b = "+diff);

        //곱셈
        int multi = a * b;
        System.out.println("a * b = "+multi);

        //나눗셈(몫)
        int div=a/b; //int형이기 때무넹 2.5가 아니라 2가 저장됨
        System.out.println("a / b = "+div);

        //나머지
        int mod = a % b;
        System.out.println("a % b = "+mod);
    }
}

/*
    int형끼리 계산하면 결과도 int형으로 나옴
    cf. 0으로 나누기는 오류 발생

*/