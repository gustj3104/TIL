package array.ex;

import java.util.Scanner;

public class ArrayEx2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        int[] numbers = new int[5];
        System.out.println("5개의 정수를 입력하세요: ");
        while (i < 5) {
            int num = scanner.nextInt();
            numbers[i] = num;
            i++;
        }

        int index = 0;
        int maxIndex = numbers.length;
        for (int number : numbers) {
            index++;
            if (index == maxIndex) {
                System.out.print(number);
            } else {
                System.out.print(number + ", ");
            }

        }
    }
}
