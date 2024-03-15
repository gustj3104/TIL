package cond;

public class CondOp2 {
    public static void main(String[] args) {
        int age = 18;
        String status = (age >= 18) ? "성인" : "미성년자";
        System.out.println("status = " + status);
    }
}
/*
조건, 참_표현식, 거짓_표현식 --> 항 3개
참이면 참_표현식이 실행되고, 거짓이면 거짓_표현식이 실행됨.

 */