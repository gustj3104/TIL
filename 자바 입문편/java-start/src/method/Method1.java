package method;

public class Method1 {
    public static void main(String[] args) {
        //계산 1
        int a = 1;
        int b = 2;
        System.out.println(a + "+"+ b + " 연산 수행");
        int sum1 = a + b;
        System.out.println("결과1 출력: " + sum1);

        //계산 2
        int x = 10;
        int y = 20;
        System.out.println(x + "+"+ y + " 연산 수행");
        int sum2 = x + y;
        System.out.println("결과2 출력: " + sum2);

    }
}

/*
같은 코드 구조에서 다른 변수를 쓴다면,,
유지 보수에도 쉽지 않고 깔끔하지 않음

변수가 아예 달라서 배열로 풀 수 없음 --> 메서드를 써보자

여러 번 같은 계산을 한다면, 함수를 정의해두고 필요한 입력 값을 넣어서 해당 함수를 호출하면 됨.
함수를 호출할 때 외부에서는 필요한 값만 입력하면 됨 -> 계산된 결과가 출력됨.

!! 한 번만 정의해도 계속해서 재사용할 수 있음 !!
 */