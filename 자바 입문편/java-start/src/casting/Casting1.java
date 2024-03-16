package casting;

public class Casting1 {
    public static void main(String[] args) {
        int intValue = 10;
        long longValue;
        double doubleValue;

        longValue = intValue;
        System.out.println("longValue = " + longValue);

        doubleValue = intValue;
        System.out.println("doubleValue = " + doubleValue);

        doubleValue = 20L; //long -> double
        System.out.println("doubleValue = " + doubleValue);
    }
}

/*
int < long < double
- 자바는 기본적으로 같은 타입에 값을 대입할 수 있음.
- 작음 범위에서 큰 범위로의 대입은 자바 언어에서 허용함.

doubleValue = intValue
doubleValue = (double) intValue
doubleValue = (double) 10
doubleValue = 10.0
--> 형변환
- 자동으로 일어나는 과정을 '자동 형변환' 또는 '묵시적 형변환'이라고 함.

 */