package cond;

public class If3 {
    public static void main(String[] args) {
        //아이템의 가격이 10000원 이상일 때, 1000원 할인
        // 나이가 10살 이하일 때 1000원 할인
        int price = 10000;
        int age=10;
        int discount = 0;

        if (price >= 10000) {
            discount = discount + 1000;
            System.out.println("10000원 이상 구매, 1000원 할인");
        }

        if (age <= 10) {
            discount = discount + 1000;
            System.out.println("어린이 1000원 할인");
        }
        System.out.println("총 할인 금액: " + discount + "원");
    }
}
/*
if 각각 사용
: 독립 조건일 때
if (condition){
    // 작업1 수행
}

if (condition2){
    //작업2 수행
}

- 조건만 맞다면 둘 다 수행될 수 있음
- 조건이 서로 영향을 주지 않고 각각 수행해야 하는 경우에는 if문을 분리해서 사용해야 함.

if-else 사용
: 서로 연관된 조건이어서 하나로 묶었을 때

 */