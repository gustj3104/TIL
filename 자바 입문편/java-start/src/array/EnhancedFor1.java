package array;

public class EnhancedFor1 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        //일반 for문
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            System.out.println(number);
        }
        
        //향상된 for문
        for (int number : numbers) { //배열의 원소를 하나씩 탐색 (인덱스와 종료조건을 주지 않아도 됨)
            System.out.println(number);
        }


    }
}

//인덱스를 직접 사용해야 하는 경우에는 향상된  for문을 사용할 수 없음.