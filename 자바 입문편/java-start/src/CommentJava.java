public class CommentJava {
    public static void main(String[] args) {
        System.out.println("hello java1"); //한 줄 주석 --> hello java1출력하기
        System.out.println("hello java2");
        /* 여러줄 주석
        System.out.println("hello java3");
        System.out.println("hello java4");
         */
    }
}

/*
자바 표준 스펙: 설계도, 문서
- 표준 스펙을 기반으로 여러 회사에서 실제 작동하는 자바를 만듦
자바 구현 - 여러 회사에서 표준 스펙에 맞추어 실제 작동하는 자바 프로그램을 만듦. AWS에 최적화된 버전, 리눅스 용 등 장단점이 있음.

컴파일과 실행
- 소스코드 작성 --> javac로 .class로 컴파일함.(바이트코드로 변환해 실행속도 최적화, 오류 검출) --> 자바 가상 머신 JVM 이 실행되면서 프로그램 실행됨

 */