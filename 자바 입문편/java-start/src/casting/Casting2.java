package casting;

public class Casting2 {
    public static void main(String[] args) {
        double doubleValue = 1.5;
        int intValue = 0;

        //intValue = doubleValue; //컴파일 오류
        intValue = (int) doubleValue; //명시적 형변환
        System.out.println(intValue); //1출력(손실 변환)
        System.out.println((int)1.5);
    }
}

/*
큰 컵에 담긴 물을 작은 컵에 옮겨 담으려고 하니, 손실이 발생할 수 있음.
위험을 감수하고도 값을 대입하고 싶다면 데이터 타입을 강제로 변경할 수 있음
== 명시적 형변환
- 변경하고 싶은 데이터 타입을 (int)와 같이 괄호를 사용해 명시적으로 입력하면 됨.

cf. 캐스트: 다른 물질을 녹여서 특정한 형태나 모양을 만드는 과정

intValue = (int) doubleValue
intValue = (int) 1.5
intValue = 1


 */