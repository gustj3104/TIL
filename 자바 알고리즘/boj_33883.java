import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_33883 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] vowels = {'a', 'e', 'o', 'u', 'i'};
    String target = br.readLine();
    StringBuilder sb = new StringBuilder(target);
    String reversed = sb.reverse().toString();

    char last = target.charAt(target.length() - 1);
    if (last == 'n' || last == 's' || isVowel(last, vowels)) {
      findSecondVowel(reversed, vowels);
    } else {
      findLastVowel(target, vowels);
    }


  }

  private static boolean isVowel(char c, char[] vowels) {
    for (char v : vowels) {
      if (c == v) return true;
    }
    return false;
  }

  public static void findSecondVowel(String reversed, char[] vowels) {
    int count = 0;
    for (int i = 0; i < reversed.length(); i++) {
      if (isVowel(reversed.charAt(i), vowels)) {
        count++;
        if (count == 2) {
          System.out.println(reversed.length() - i);
          return;
        }
      }
    }
    System.out.println(-1);
  }

  public static void findLastVowel(String target, char[] vowels) {
    for (int i = target.length() - 1; i >= 0; i--) {
      if (isVowel(target.charAt(i), vowels)) {
        System.out.println(i + 1);
        return;
      }
    }
    System.out.println(-1);
  }

}

/*
규칙적 강세 규칙
n, s 외 자음으로 끝나는 단어 -> 마지막 모음에 강세
모음으로 끝나는 단어/ n, s로 끝나는 단어는 뒤에서 두번째 모음에 강세를 줌
강세가 붙는 문자가 몇 번째에 위치하는지 출력
 */