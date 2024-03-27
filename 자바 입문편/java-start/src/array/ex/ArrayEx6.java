package array.ex;

import java.util.Scanner;

public class ArrayEx6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("입력받을 숫자의 개수를 입력하세요: ");
        int inputNum = scanner.nextInt();
        int[] numbers = new int[inputNum];

        System.out.println(inputNum + "개의 정수를 입력하세요: ");
        for(int i=0;i< inputNum;i++){
            numbers[i] = scanner.nextInt();
        }

        int minNum = numbers[0];
        int maxNum = numbers[0];

        for (int number : numbers) {
            if (number < minNum) {
                minNum = number;
            } else if (number > maxNum) {
                maxNum = number;
            }
        }

        System.out.println("가장 작은 정수: " + minNum);
        System.out.println("가장 큰 정수: "+maxNum);


    }
}
