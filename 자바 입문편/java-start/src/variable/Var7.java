package variable;

public class Var7 {
    public static void main(String[] args) {
        int a=100; //정수
        double b=10.5; //실수
        boolean c=true; //true, false
        char d ='A'; //문자 하나
        String e = "Hello Java"; //문자열

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
    }
}

/*
    변수는 데이터를 다루는 종류에 따라 다양한 형식이 존재함.
    int: 정수
    double: 실수
    boolean: true/False
    char: 문자 하나 --> 작은 따옴표로 감싸서 사용
    String: 문자열 --> 큰 따옴표로 감싸서 사용

    각 변수는 지정한 타입에 맞는 값을 사용해야 함.
    int z="백원"; --> 오류, int a="100"; --> 오류 [쌍따옴표로 감싸면 문자열로 판단함.]

    개발자가 직접 적은 값(100, 10.5, true, A, Hello Java)은 리터럴이라고 함. --> 고정된 값


 */