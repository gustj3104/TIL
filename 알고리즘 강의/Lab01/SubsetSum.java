package Lab01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubsetSum {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      int n = Integer.parseInt(br.readLine());
      int[] X = new int[n];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        X[i] = Integer.parseInt(st.nextToken());
      }

      int target = Integer.parseInt(br.readLine());
      boolean ok = ss(X, 0, target);
      sb.append(ok ? "YES" : "NO").append('\n');
    }

    System.out.println(sb);

  }

  static boolean ss(int[] X, int i, int target) {
    if (target == 0) return true;
    if (i == X.length || target < 0) {
      return false;
    }

    return ss(X, i + 1, target) || ss(X, i + 1, target - X[i]);
  }
}