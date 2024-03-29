package method;

public class Method1Ref {
    public static void main(String[] args) {
        //계산 1
        int sum1 = add(5, 10);
        System.out.println("결과1 출력: " + sum1);

        //계산 2
        int sum2 = add(10, 20);
        System.out.println("결과2 출력: " + sum2);

    }

    //add 메서드
    public static int add(int a, int b) { // int형으로 반환
        System.out.println(a + "+"+ b + " 연산 수행");
        int sum = a + b;
        return sum;
    }
}

/*
코드를 수정할 때 메서드에서만 수정하면 됨.
-> 중복이 제거되고 코드가 깔끔해짐

메서드
= 메서드 선언 + 메서드 본문
1) 메서드 선언
public static int add(int a, int b)
메서드 이름, 반환 타입, 파라미터 목록을 포함함.
메서드 선언 정보를 통해 다른 곳에서 해당 메서드를 실행할 수 있음.
- public static
    - public: 다른 클래스에서 호출할 수 있는 메서드라는 의미.
    - static: 객체를 생성하지 않고 호출할 수 있는 정적 메서드라는 의미.
- int add(int a, int b)
    - int: 반환 타입 정의. 메서드의 실행 결과를 반환할 때 사용될 반환 타입을 정의함.
    - add: 메서드에 이름을 부여함. 이 이름을 통해 메서드를 호출할 수 있음.
    - int a, int b: 메서드를 호출할 때 전달할 입력 값을 정의한 것. 이 변수는 해당 메서드 안에서만 사용함. == 매개변수, 파라미터

2) 매서드 본문
{
    System.out.println(a + "+"+ b + " 연산 수행");
    int sum = a + b;
    return sum;
}
- 메서드가 수행해야 하는 코드 블록
- 메서드가 호출하면 메서드 본문이 순서대로 실행됨.
- 메서드 본문은 블랙박스 -> 메서드를 호출하는 곳에서는 메서드 선언은 알지만, 메서드 본문은 모름.
- 메서드의 실행결과를 반환하려면 return문을 사용해야 함.


용어 정리
1. 인수
: 호출자 입장에서 넘기는 값 (아규먼트, 인수, 인자 등)

2. 매개변수
: 메서드를 정의할 때 선언한 변수
- 메서드 호출부와 메서드 내부 사이에서 값을 전달하는 역할을 하는 변수

=> 메서드를 호출할 때 인수를 넘기면, 그 인수가 매개변수에 대입됨.

---------------------------------------------------------------

public static int add(int a, int b) { ... }
 = 제어자 반환타입 메서드명(매개변수 목록) {메서드본문}
1. 제어자(Modifier)
    : public, static 과 같은 부분
2. 반환 타입(Return Type)
    : 메서드가 실행된 후 반환하는 데이터 타입 정의
    - 메서드가 값을 반환하지 않는 경우, 없다는 뜻의 void를 사용해야 함. (void print(String str))

3. 메서드명(Method Name)
    : 메서드의 이름 -> 호출할 때 사용함.

4. 매개변수(Parameter)
    : 입력값, 메서드 내부에서 사용할 수 있는 변수
    - 매개변수는 옵션임. 입력값이 필요없는 메서드는 매개변수를 지정하지 않아도 됨.

5. 메서드 본문(Method Body)
    : 실제 메서드의 코드
    - 중괄호 사이에 코드를 작성함.
 */