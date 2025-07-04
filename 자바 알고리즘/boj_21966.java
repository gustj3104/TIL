import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class boj_21966 {

  private static final int MAX_LEN = 25;
  private static final int EDGE_LEN = 11;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String s = br.readLine();

    if (n <= MAX_LEN) {
      System.out.println(s);
      return;
    }


    String middle = s.substring(EDGE_LEN, n - EDGE_LEN - 1);

    if (middle.contains(".")) {
      String dots = "......";
      String front = s.substring(0, 9);
      String back = s.substring(n - 10);
      System.out.println(front + dots + back);
    } else {
      String dots = "...";
      String front = s.substring(0, 11);
      String back = s.substring(n - 11);
      System.out.println(front + dots + back);

    }

  }

}

/*
문자열 길이가 25 이하이면 그대로 출력
초과이면 앞에서부터 11글자, 뒤에서부터 11글자 제외 나머지 부분만 해당
    - 나머지 부분이 모두 같은 문장에 속한다면 ...으로 변환
    - 같은 문장에 속하지 않으면 앞에서부터 9글자, 뒤에서부터 10글자 남기고 중간을 ......으로 변환

1. 길이 <= 25 : 그대로
2. 길이 > 25 && 마지막 문자 = "." : ...으로
3. 길이 > 25 && 문장 중간에 "." : ......으로
 */