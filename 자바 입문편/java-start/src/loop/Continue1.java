package loop;

public class Continue1 {
    public static void main(String[] args) {
        int i = 1;

        while (i <= 5) {
            if (i == 3) {
                i++;
                continue;//i가 3일 때만 반복문을 건너뜀.
            }
            System.out.println(i);
            i++;
        }
    }
}
