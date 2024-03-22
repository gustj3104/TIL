package array;

public class Array1Ref1 {
    public static void main(String[] args) {
        int[] students; //배열 변수 선언
        students = new int[5]; //배열 크기 정의 (총 5개의 int형을 넣을 수 있음.)

        //변수 값 대입
        students[0] = 90;
        students[1] = 90;
        students[2] = 80;
        students[3] = 70;
        students[4] = 60;

        System.out.println("학생1 점수: " + students[0]);
        System.out.println("학생2 점수: " + students[1]);
        System.out.println("학생3 점수: " + students[2]);
        System.out.println("학생4 점수: " + students[3]);
        System.out.println("학생5 점수: " + students[4]);
    }
}

/*
students = new int[5];
- new: 새로 생성한다.
- int[5]: int형 변수 5개라는 뜻
= int형 변수 5개를 다룰 수 있는 배열을 새로 만든다

- 배열이 생성될 때 그 내부값은 자동으로 초기화된다.(0, false, nul)
- 배열을 생성하면 배열의 크기만큼 메모리를 확보한다. 그리고 메모리 어딘가에 배열에 접근할 수 있는 참조값(주소)을 반환한다. --> students에 저장됨.
따라서 new int[5]로 배열을 생성하고 그 주소를 students에 저장함.


 */