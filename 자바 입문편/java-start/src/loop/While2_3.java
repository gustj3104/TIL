package loop;

public class While2_3 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        int endNum = 3;

        while(i <=endNum){ //i가 endNum이 될 때까지 반복
            sum = sum + 1;
            System.out.println("i="+i+"sum = " + sum);
            i++;
        }
    }
}
