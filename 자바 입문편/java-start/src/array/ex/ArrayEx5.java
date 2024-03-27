package array.ex;

import java.util.Scanner;

public class ArrayEx5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        System.out.print("입력받을 숫자의 개수를 입력하세요: ");
        int inputNum = scanner.nextInt();
        int[] numbers = new int[inputNum];

        System.out.println(inputNum + "개의 정수를 입력하세요: ");
        for(int i=0;i< inputNum;i++){
            numbers[i] = scanner.nextInt();
            sum += numbers[i];
        }

        double average = (double) sum / numbers.length;

        System.out.println("입력한 정수의 합계: " + sum);
        System.out.println("입력한 정수의 평균: " + average);
    }
}
