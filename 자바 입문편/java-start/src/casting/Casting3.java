package casting;

public class Casting3 {
    public static void main(String[] args) {
        long maxIntValue = 2147483647L; //int 최고값
        long maxIntOver = 2147483648L; //int 최고값 + 1 (초과)
        int intValue = 0;

        intValue = (int) maxIntValue;
        System.out.println("maxIntValue casting = " + intValue);

        intValue = (int) maxIntOver;
        System.out.println("maxIntOver casting=" + intValue); // - 2147483648 출력됨 --> int의 제일 작은 값
    }
}

/*

overflow문제가 발생하면
int 범위의 처음으로 돌아감
순환하는 구조처럼

중요한 건 오버플로우가 발생하는 것 자체임
결과가 어떻게 되는지 계산하는데 시간을 낭비하면 안됨. 애초에 발생하지 않도록 해야함.
그냥 int 말고 long을 써야하는 거임
비행기가 추락하고 있는데 추락할 곳을 계산하고 있는 거랑 같은 거임;;

 */
