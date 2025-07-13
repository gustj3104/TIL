import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1015 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] A = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    Integer[] B = new Integer[N];
    for (int i = 0; i < N; i++) {
      B[i] = i;
    }
    Arrays.sort(B, (i, j) -> {
      if (A[i] != A[j]) {
        // 값이 동일하지 않으면 값으로 오름차순
        return Integer.compare(A[i], A[j]);
      } // 값이 동일하면 인덱스 오름차순
      return Integer.compare(i, j);
    });

    System.out.println(Arrays.toString(B));

    int[] P = new int[N];
    for (int i = 0; i < N; i++) {
      int o = B[i];
      P[o] = i;
    }

    for (int p : P) {
      System.out.print(p + " ");
    }
  }
}
