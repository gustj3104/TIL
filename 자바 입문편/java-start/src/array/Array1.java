package array;

public class Array1 {
    public static void main(String[] args) {
        int student1 = 90;
        int student2 = 80;
        int student3 = 70;
        int student4 = 60;
        int student5 = 50;


        System.out.println("학생1 점수: " + student1);
        System.out.println("학생2 점수: " + student2);
        System.out.println("학생3 점수: " + student3);
        System.out.println("학생4 점수: " + student4);
        System.out.println("학생5 점수: " + student5);
    }
}

/*
학생 수가 증가하면 증가할수록 int 선언, 출력이 계속 늘어남.
변수 이름이 다 달라서 반복문으로도 해결하기 어려움.
--> 배열을 사용해보자!
 */