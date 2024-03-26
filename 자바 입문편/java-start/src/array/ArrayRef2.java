package array;

public class ArrayRef2 {
    public static void main(String[] args) {
        int[] students;
        students = new int[5];

        students[0] = 90;
        students[1] = 90;
        students[2] = 80;
        students[3] = 70;
        students[4] = 60;

        for (int i = 0; i < students.length; i++) {
            System.out.println("학생"+(i+1)+" 점수: "+students[i]);
        }
    }
}
// length는 배열의 길이를 조회할 수 있음(대입은 불가능)
