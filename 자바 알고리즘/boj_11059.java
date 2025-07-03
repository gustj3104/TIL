import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11059 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    int n = s.length();
    int maxLen = 0;

    int[] ps = new int[n + 1]; // 누적합 배열
    for (int i = 0; i < n; i++) {
      ps[i + 1] = ps[i] + (s.charAt(i) - '0');
    }

    for (int i = 0; i < n; i++) {
      for (int j = 2; j + i <= n; j += 2) {
        int mid = i + j / 2;
        int front = ps[mid] - ps[i]; // 앞부분 합
        int back = ps[i + j] - ps[mid]; // 뒷부분 합
        if (front == back && j > maxLen) {
          maxLen = j;
        }
      }
    }

    System.out.println(maxLen);
  }
}