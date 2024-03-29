package method;

public class Overloading3 {

    public static void main(String[] args) {
        System.out.println("1: " + add(1, 2));
        System.out.println("2: " + add(1.2, 1.5));
    }

    public static double add(double a, double b) {
        System.out.println("2번 호출");
        return a + b;
    }
}
//add(1, 2)는 최대한 본인의 타입에 맞는 int add()를 호출하고, 안되면 자동형변환 가능한 메서드를 찾음.