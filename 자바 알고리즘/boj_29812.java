import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_29812 {

  public static void main(String[] args) throws IOException {
    // H, Y, U 각각 개수 카운트
    // 다른 연속된 문자열이 왔을 때, 드래그 vs. 개별 삭제 중 에너지가 적게 드는 것 판별
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    String S = br.readLine();
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int D = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int Hcount = 0, YCount = 0, UCount = 0;
    int minE = 0;
    int con = 0;

    for (int i = 0; i < T; i++) {
      char c = S.charAt(i);
      if (c == 'H') {
        Hcount++;
        if (con > 0) {
          minE += Math.min((con * D), M + D);
          con = 0;
        }
      } else if (c == 'Y') {
        YCount++;
        if (con > 0) {
          minE += Math.min(con * D, M + D);
          con = 0;
        }
      } else if (c == 'U') {
        UCount++;
        if (con > 0) {
          minE += Math.min(con * D, M + D);
          con = 0;
        }
      } else {
        con++;
      }
    }

    if (con > 0) {
      minE += Math.min(con * D, M + D);
    }

    if (minE == 0) {
      System.out.println("Nalmeok");
    } else {
      System.out.println(minE);
    }


    int minWord = Math.min(Math.min(Hcount, YCount), UCount);

    if (minWord == 0) {
      System.out.println("I love HanYang University");
    } else {
      System.out.println(minWord);
    }




  }

}
