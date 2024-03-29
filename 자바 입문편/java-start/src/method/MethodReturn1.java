package method;

public class MethodReturn1 {

    public static void main(String[] args) {
        boolean result = odd(2); //false일 때 return 값이 없음. -> 컴파일 오류 발생
        System.out.println(result);

    }

    public static boolean odd(int i) {
        if ((i % 2) == 1) {
            return true;
        } else { //false인 경우를 추가해줘야 함. == 항상 리턴을 하는 것이 보장된다.
            return false;
        }
    }
}

/*
return 문을 만나면 그 즉시 메서드를 빠져나감.
 */
