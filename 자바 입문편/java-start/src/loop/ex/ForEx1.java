package loop.ex;

public class ForEx1 {
    public static void main(String[] args) {
        /*
        int num = 2;

        for (int count =1; count <= 10; count++) {
            System.out.println(num);
            num += 2;
        }
        */

        for (int count = 1, num = 2; count <= 10; count++, num += 2) {
            System.out.println(num);
        }
    }
}
