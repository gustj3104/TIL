package operator;

public class OperatorAdd2 {
    public static void main(String[] args) {
        //전위 증감 연산자 사용 예
        int a=1;
        int b=0;

        b=++a; //a의 값을 먼저 증가시키고, b에 대입
        System.out.println("a = " + a + ", b = " + b);

        //후위 증감 연산자 사용 예
        a=1;
        b=0;

        b=a++; //a의 값을 b에 대입시키고, a 값 증가시킴
        System.out.println("a = " + a+ ", b = "+b);
    }
}
/*
b=a++
b=a
a=a+1

b=++a
a=a+1
b=a

++a / a++ 단독으로 쓰는 경우에는 똑같이 1 증가하는 결과가 나옴
 */