package cond;

public class If2 {
    public static void main(String[] args) {
        int age = 14;
//        if (age <= 7) {
//            System.out.println("미취학");
//        }
//        if (age >= 8 && age <= 13) {
//            System.out.println("초등학생");
//        }
//        if (age >= 14 && age <= 16) {
//            System.out.println("중학생");
//        }
//        if (age >= 17 && age <= 19) {
//            System.out.println("고등학생");
//        }
//        if (age > 20) {
//            System.out.println("성인");
//        }
        //8살인 아이라면? 두 번째 if절에서 이미 초등학생인 걸 판명함. == 다른 조건은 false임.(중복 체크하게 됨) --> 코드 효율성이 좋지 않음.

        if (age <= 7) {
            System.out.println("미취학");
        } else if  (age <= 13) { //조건1이 거짓이고, 조건2가 참일 때 실행되는 코드
            System.out.println("초등학생");
        } else if (age <= 16) {
            System.out.println("중학생");
        } else if (age <= 19) {
            System.out.println("고등학생");
        } else {
            System.out.println("성인");
        }
    }
}
