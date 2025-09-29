package Lab01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      int[] L = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        L[i] = Integer.parseInt(st.nextToken());
      }

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < m; i++) {
        int q = Integer.parseInt(st.nextToken());
        int idx = bsearch(L, q);
        sb.append(idx).append(' ');
      }
      sb.setCharAt(sb.length() - 1, '\n');
    }
    System.out.println(sb);
  }

  static int bsearch(int[] L, int q) {
    int start = 0, last = L.length - 1;
    while (start <= last) {
      int mid = (start + last) >>> 1;
      if (L[mid] == q) {
        return mid;
      }
      if (L[mid] < q) {
        start = mid + 1;
      } else {
        last = mid - 1;
      }
    }
    return -1;
  }
}
