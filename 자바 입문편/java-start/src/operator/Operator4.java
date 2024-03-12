package operator;

public class Operator4 {
    public static void main(String[] args) {
        int sum3 = 2 * 2 + 3 * 3;
        int sum4 = (2*2) + (3*3);
        System.out.println("sum3 = " + sum3);
        System.out.println("sum4 = " + sum4);
    }
}

/*
복잡한 수식은 괄호를 명시적으로 사용하는 걸 권장 --> 가독성이 좋고, 명확함
명확하고 단순한 게 유지 보수하기 좋다

우선순위는 외울 필요없다..
- 상신선에서 우선순위를 사용하자 (덧셈보다 곱셈이 먼저인 건 당연하니까)
- 애매하면 괄호를 사용하자
 */