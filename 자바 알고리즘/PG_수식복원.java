import java.util.*;

public class PG_수식복원 {
  public static void main(String[] args) {
    Solution sol = new Solution();

    String[] expressions1 = {
        "14 + 3 = 17", "13 - 6 = X", "51 - 5 = 44"
    };
    String[] expressions2 = {
        "1 + 1 = 2", "1 + 3 = 4", "1 + 5 = X", "1 + 2 = X"
    };
    String[] expressions3 = {
        "10 - 2 = X", "30 + 31 = 101", "3 + 3 = X", "33 + 33 = X"
    };
    String[] expressions4 = {
        "2 - 1 = 1", "2 + 2 = X", "7 + 4 = X", "5 - 5 = X"
    };
    String[] expressions5 = {
        "2 - 1 = 1", "2 + 2 = X", "7 + 4 = X", "8 + 4 = X"
    };

    System.out.println("== 테스트 케이스 1 ==");
    System.out.println(Arrays.toString(sol.solution(expressions1)));

    System.out.println("== 테스트 케이스 2 ==");
    System.out.println(Arrays.toString(sol.solution(expressions2)));

    System.out.println("== 테스트 케이스 3 ==");
    System.out.println(Arrays.toString(sol.solution(expressions3)));

    System.out.println("== 테스트 케이스 4 ==");
    System.out.println(Arrays.toString(sol.solution(expressions4)));

    System.out.println("== 테스트 케이스 5 ==");
    System.out.println(Arrays.toString(sol.solution(expressions5)));
  }
}

class Solution {
  public String[] solution(String[] expressions) {
    List<String> answer = new ArrayList<>();

    // 최소 진법 확인 : 피연산자, 결과에 있는 숫자 중 가장 큰 숫자를 찾아 저장
    int maxDigit = 0;
    for (String expr : expressions) {
      String[] parts = expr.split(" ");
      for (String token : new String[]{parts[0], parts[2], parts[4]}) {
        if (!token.equals("X")) {
          for (char ch : token.toCharArray()) {
            maxDigit = Math.max(maxDigit, ch - '0');
          }
        }
      }
    }
    // 최소 2진법부터 시작, 가장 큰 숫자와 비교해서 최소 진법 결정
    int minBase = Math.max(2, maxDigit + 1);


    // 후보 진법 셋
    Set<Integer> validBases = new HashSet<>();

    // 최소 진법부터 9진법까지 후보 진법 검사
    for (int base = minBase; base <= 9; base++) {
      boolean valid = true;
      for (String expr : expressions) {
        String[] p = expr.split(" ");
        String a = p[0], op = p[1], b = p[2], c = p[4]; // 피연산자, 결과 분할

        if (c.equals("X")) continue; // X있는 식은 건너뜀
        if (!validIn(a, base) || !validIn(b, base) || !validIn(c, base)) { // 자리의 숫자가 모두 진법보다 숫자가 작아야 유효함
          valid = false; break;
        }

        // 피연산자, 결과 -> 진법 변환
        int A = Integer.parseInt(a, base),
            B = Integer.parseInt(b, base),
            C = Integer.parseInt(c, base),
            calc = op.equals("+") ? A + B : A - B; // 연산
        if (calc != C) { valid = false; break; }
      }
      if (valid) validBases.add(base);
    }

    // X가 있는 수식 연산 적용
    for (String expr : expressions) {
      String[] p = expr.split(" ");
      String a = p[0], op = p[1], b = p[2], c = p[4];
      if (!c.equals("X")) continue; // X가 없는 식은 건너뜀

      // X가 있는 수식의 결과 저장
      Set<String> results = new HashSet<>();
      for (int base : validBases) {
        if (!validIn(a, base) || !validIn(b, base)) continue; //피연산자 유효성 검사

        // 피연산자 -> 진법 변환
        int A = Integer.parseInt(a, base);
        int B = Integer.parseInt(b, base);
        int calc = op.equals("+") ? A + B : A - B;
        if (calc < 0) continue;

        // 결과 -> 진법 변환, 유효성 검사
        String rs = Integer.toString(calc, base);
        if (!validIn(rs, base)) continue;
        // 정수 변환해도 그대로 결과 유지되는지 확인
        if (Integer.parseInt(rs, base) != calc) continue;
        results.add(rs);
      }
      if (results.size() == 1) { // 결과가 유일하면 출력
        answer.add(String.format("%s %s %s = %s", a, op, b, results.iterator().next()));
      } else { // 유일하지 않으면 ? 출력
        answer.add(String.format("%s %s %s = ?", a, op, b));
      }
    }

    return answer.toArray(new String[0]);
  }

  private boolean validIn(String s, int base) {
    for (char ch : s.toCharArray()) {
      // 숫자가 아니거나 진법(base)보다 크면 유효하지 않음
      if (!Character.isDigit(ch) || (ch - '0') >= base) return false;
    }
    return true;
  }
}
