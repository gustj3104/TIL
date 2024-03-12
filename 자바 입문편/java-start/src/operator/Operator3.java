package operator;

public class Operator3 {
    public static void main(String[] args) {
        int sum1 = 1 + 2 * 3;
        int sum2 = (1+2) * 3;
        System.out.println("sum1 = " + sum1);
        System.out.println("sum2 = " + sum2);

    }
}

/*
연산자 우선순위는 덧셈 < 곱셈
괄호로 우선순위를 변경할 수 있음
 */