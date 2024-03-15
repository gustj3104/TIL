package cond;

import java.sql.SQLOutput;

public class If4 {
    public static void main(String[] args) {
        int price = 10000;
        int age=10;
        int discount = 0;

        if (price >= 10000) {
            discount = discount + 1000;
            System.out.println("10000원 이상 구매, 1000원 할인");
        } else if (age <= 10) {
            discount = discount + 1000;
            System.out.println("어린이 1000원 할인");
        } else {
            System.out.println("할인 없음");
        }
        System.out.println("총 할인 금액: " + discount + "원");

        if(true) System.out.println("코드가 한 줄이면 중괄호가 없어도 됨 (권장하진 않음)");
    }
}
// 중복 할인 안됨.
