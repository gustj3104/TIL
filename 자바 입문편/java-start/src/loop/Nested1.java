package loop;

public class Nested1 {
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            System.out.println("외부 for 시작 i: " + i);
            //내부 for문은 2 * 3번 총 6번이 실행됨.
            for (int j = 0; j < 3; j++) {
                System.out.println("-->내부  for " + i + "-" + j);
            }
            System.out.println("외부 for 종료 i:" + i);
            System.out.println();
        }

    }
}
