package loop.ex;

public class WhileEx2 {
    public static void main(String[] args) {
        int num = 1;
        int max = 100;
        int sum = 0;

        while (num <= max) {
            sum += num;
            num++;
        }
        System.out.println(sum);
    }
}
