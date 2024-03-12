package operator;

public class Operator2 {
    public static void main(String[] args) {
        String result1 = "hello" + "world";
        System.out.println(result1);

        //문자열끼리 더하기
        String s1 = "string1";
        String s2 = "string2";
        String result2=s1+s2;
        System.out.println(result2);

        //문자열과 숫자 더하기
        int num = 20;
        String str = "a + b =";
        String result3 = str + num;
        System.out.println(result3); //숫자를 문자열로 처리하여 출력함 == "a + b =" + "20"


    }
}
