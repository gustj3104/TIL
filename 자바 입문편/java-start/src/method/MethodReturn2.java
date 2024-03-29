package method;

import java.sql.SQLOutput;

public class MethodReturn2 {

    public static void main(String[] args) {
        checkAge(10); //return문을 만나서 메서드를 빠져나왔기 때문에 '입장하세요'는 출력되지 않음.
        checkAge(20);
    }

    public static void checkAge(int age){
        if (age < 18) {
            System.out.println(age + "살, 미성년자는 출입이 불가능합니다.");
            return;
        }

        System.out.println(age + "살, 입장하세요");
    }
}

