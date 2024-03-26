package array;

public class ArrayDi2 {
    public static void main(String[] args) {
        //2 x 3 2차원 배열 생성,초기화
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6, 7}
        };
//        {{1,2,3},{4,5,6}} 으로 선언해야 함.

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }
}
