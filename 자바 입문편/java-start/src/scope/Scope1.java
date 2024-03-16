package scope;

public class Scope1 {
    public static void main(String[] args) {
        int m = 10; //m 생존 시작
        if (true) {
            int x = 20;//x 생존 시작
            System.out.println("if m = " + m);
            System.out.println("if x = " + x);
        } //x의 생존 범위 종료 (선언된 블록 안에서만 생존함)
//        System.out.println("main x = " + x);//컴파일 오류
        System.out.println("main m = " + m);
    } // m 생존 종료
}
/*
지역변수는 본인의 코드 블록 안에서만 생존함.
자신의 코드 블록 안에서는 얼마든지 접근할 수 있지만 자신의 코드 블록을 벗어나면 제거되기 때문에 접근할 수 없음.

스코프: 변수의 접근 가능 범위
 */