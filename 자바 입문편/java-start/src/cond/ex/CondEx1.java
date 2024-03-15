package cond.ex;

public class CondEx1 {
    public static void main(String[] args) {
        int score = 80;
        if (score >= 90) {
            System.out.println("A");
        } else if (80 <= score && score < 90) {
            System.out.println("B");
        } else if (70 <= score && score < 80) {
            System.out.println("C");
        } else if (60 <= score && score < 70) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }

    }
}
