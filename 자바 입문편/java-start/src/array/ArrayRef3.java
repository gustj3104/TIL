package array;

public class ArrayRef3 {
    public static void main(String[] args) {
        int[] students;
        students = new int[]{
                90, 80, 70, 60, 50}; //배열 생성과 초기화

        //변수 값 사용
        for (int i = 0; i < students.length; i++) {
            System.out.println("학생"+(i+1)+" 점수: "+students[i]);
        }
    }
}
// length는 배열의 길이를 조회할 수 있음(대입은 불가능)
