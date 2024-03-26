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
- int[5]: int형 변수 5개라는 뜻ㄴ
= int형 변수 5개를 다룰 수 있는 배열을 새로 만든다

- 배열이 생성될 때 그 내부값은 자동으로 초기화된다.(0, false, nul)
- 배열을 생성하면 배열의 크기만큼 메모리를 확보한다. 그리고 메모리 어딘가에 배열에 접근할 수 있는 참조값(주소)을 반환한다. --> students에 저장됨.
따라서 new int[5]로 배열을 생성하고 그 주소를 students에 저장함.

배열의 크기에 초과해서 값을 부여하면 ArrayIndexOutOfBoundException 오류가 발생함.
배열을 왜 쓸까?
기본형은 사이즈가 모두 명확하게 정해져 있다. int(4byte)/배열은 동적으로 사이즈를 변경할 수 있음.
사용자 입력에 따라 size 변수를 설정하고, int[size] 등으로 배열을 선언한다면 배열의 크기도 달라질 수 있음 => 동적 메모리 할당

자바의 데이터 타입은 참조형, 기본형으로 분류할 수 있음.
기본형(Primitive Type): int, long, double, boolean 등 변수에 사용값을 직접 넣을 수 있는 데이터 타입
참조형(Reference Type): int[], students와 같이 데이터에 접근하기 위한 주소를 저장하는 데이터 타입. 객체, 클래스를 담을 수 있는 변수도 참조형임.

리펙토링
: 기존의 코드 기능은 유지하면서 내부 구조를 개선하여 가독성을 높이고, 유지보수를 용이하게 하는 과정
- 중복제거, 복잡성 줄이기, 이해하기 쉬운 코드 만들기
- 버그를 줄이고 프로그램 성능을 향상시킬 수 있어 코드 설계를 개선하는 데에 도움이 됨.
= 작동하는 기능은 똑같은데, 코드를 개선하는 것
 */