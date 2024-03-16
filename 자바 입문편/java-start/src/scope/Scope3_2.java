package scope;

public class Scope3_2 {
    public static void main(String[] args) {
        int m = 10;

        if (m > 0) {
             int temp = m * 2; //temp의 스코프가 if문 블록으로 줄어듦.
            System.out.println("temp = " + temp);
        }
        System.out.println("m = " + m);
    }
}

/*
변수는 꼭 필요한 범위로 한정해서 사용하는 것이 좋음. --> 변수의 스코프는 꼭 필요한 곳으로 한정해서 사용하자
= 메모리를 효율적으로 사용하고 더 유지보수하기 좋은 코드를 만들 수 있다

- 좋은 프로그램은 무한한 자유가 있는 프로그램이 아니라 적절한 제약이 있는 프로그램이다
 */