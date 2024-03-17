package casting;

public class Casting4 {
    public static void main(String[] args) {
        int div1 = 3 / 2; //div1 = (int)/(int) ==> int로 계산
        System.out.println("div1 = " + div1); //1

        double div2 = 3 / 2; // div2 = (int)/(int) ==> int로 계산 == 1로 계산 -> double 로 자동 형변환 == 1.0
        System.out.println("div2 = " + div2); //1.0

        double div3 = 3.0 / 2; // div3 = (int)/(double) ==> 자동 형변환 == (double)/(double) --> double 로 계산 == 1.5
        System.out.println("div3 = " + div3); //1.5

        double div4 = (double) 3 / 2; // (double) int / int --> double/int ==> 자동형변환 --> double/double == 1.5
        System.out.println("div4 = " + div4); //1.5

        int a = 3;
        int b = 2;
        double result = (double) a / b;
        System.out.println("result = " + result); //1.5
    }
}
/*
- 같은 타입끼리의 계산은 같은 타입의 결과를 낸다.
- 서로 다른 타입의 계산은 큰 범위로 자동 형변환이 일어난다.
(int + long = long)
 */