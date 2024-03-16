package scope;

public class Scope3_1 {
    public static void main(String[] args) {
        int m = 10;
        int temp = 0;

        if (m > 0) {
            temp = m * 2;
            System.out.println("temp = " + temp);
        }
        System.out.println("m = " + m);
    }
}

/*
temp는 if조건이 만족할 때 임시로 잠깐 사용하는 변수임.
--> 비효율적인 메모리 사용 문제, 코드 복잡성 증가

- temp는 if 코드 블록에서 필요하지만, main() 코드 블록이 종료될 때까지 메모리에 유지됨 = 불필요한 메모리 낭비
- if 안에서 temp를 선언했다면 if가 끝나고 나서는 temp를 전혀 신경쓰지 않아도 됨.
 */