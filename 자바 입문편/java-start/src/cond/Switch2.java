package cond;

public class Switch2 {
    public static void main(String[] args) {
        int grade = 2;
        int coupon;

        switch (grade) {
            case 1:
                coupon = 1000;
                break;
            case 2:
                coupon = 2000;
                break;
            case 3:
                coupon = 3000;
                break;
            default:
                coupon = 500;
        }
        System.out.println("발급받은 쿠폰 "+coupon);
    }
}
/*
if VS switch
- switch는 값이 같은지 확인하는 연산만 가능함
--> 특정값에 따라 코드를 실행할 땐 switch문을 사용하면 간결한 코드를 작성할 수 있음.
근데 사실 그냥 if문 쓰긴 함 ^^,, --> 새로운 switch문 등장!
 */