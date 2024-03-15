package cond;

public class Switch1 {
    public static void main(String[] args) {
        int grade = 2;
        int coupon;

        if (grade == 1) {
            coupon = 1000;
        } else if (grade == 2) {
            coupon = 2000;
        } else if (grade == 3) {
            coupon = 3000;
        } else {
            coupon = 500;
        }
        System.out.println("발급받은 쿠폰 "+coupon);
    }
}
/*
switch문은 단순히 값이 같은지만 비교할 수 있음.
- 조건식의 결과 값이 value일 때만 실행됨.

switch(조건식){
    case value1:
        //실행 코드
        break;
    default:
        //조건식의 결과값이 위의 어떤 값에도 해당되지 않을 때 실행되는 코드

 */