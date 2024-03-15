package cond.ex;

public class CondEx2 {
    public static void main(String[] args) {
        int distance = 80;
        if (distance > 100) {
            System.out.println("비행기");
        } else if (distance <= 100) {
            System.out.println("자동차");
        } else if (distance <= 10) {
            System.out.println("자전거");
        } else {
            System.out.println("도보");
        }

    }
}
