package cond;

public class If1 {
    public static void main(String[] args) {
        int age = 20;

        if (age >= 18) { //조건이 참으로 판명됨 -> 블록 내 코드 실행
            System.out.println("성인입니다.");
        } else { //if문의 조건 실행 --> 그렇지 않으면(false이면) --> else 실행
            System.out.println("미성년자입니다.");
        }

//        if (age < 18) { //조건이 거짓으로 판명됨. -> if문 블록이 수행되지 않고, 빠져나옴.
//            System.out.println("미성년자입니다.");
//        }

    }
}

/*
조건이 true일 때 블록 내의 코드가 실행됨.

 */