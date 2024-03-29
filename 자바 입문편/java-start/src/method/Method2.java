package method;

public class Method2 {

    public static void main(String[] args) {
        printHeader();
        System.out.println("프로그램이 동작합니다.");
        printFooter();
    }

    // 매개변수, 반환값이 없는 경우
    public static void printHeader() {
        System.out.println("= 프로그램을 시작합니다 =");
        return; //모든 메서드는 항상 return을 호출해야 하지만 void는 비워둘 수 있음.
    }

    public static void printFooter(){
        System.out.println("= 프로그램을 종료합니다.=");
        return;
    }
}

