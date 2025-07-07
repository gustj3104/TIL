import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_27891 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String name = br.readLine();
    char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    String[] univ = {"northlondo", "branksomeh", "koreainter", "stjohnsbur"};
    String[] real_univ = {"NLCS", "BHA", "KIS", "SJA"};

    for (int i = 0; i < 26; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < name.length(); j++) {
        char a = name.charAt(j);
        int idx = a - 'a';
        char c = alpha[(idx + i) % 26];
        sb.append(c);
      }

      for (int j = 0; j < univ.length; j++) {
        if (sb.toString().equals(univ[j])) {
          System.out.println(real_univ[j]);
          return;
        }
      }

    }
  }

}

/*
1. 공백, 문장 부호 제거
2. 대문자 -> 소문자
3. 첫 10글자 제외 모든 글자 삭제
4. 0 ~ 25 중 N칸 앞으로 이동
 */