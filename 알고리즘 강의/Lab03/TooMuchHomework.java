package Lab03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TooMuchHomework {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine());
      int[][] homework = new int[n][2]; // [s][d]
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        homework[i][0] = Integer.parseInt(st.nextToken());
      }
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        homework[i][1] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(homework, Comparator.comparingInt((int[] x) -> x[1]));
      PriorityQueue<Integer> minHeap = new PriorityQueue<>();
      long sum = 0;
      for (int i = 0; i < n; i++) {
        int s = homework[i][0];
        int d = homework[i][1];
        minHeap.add(s);
        sum += s;
        if (minHeap.size() > d) {
          sum -= minHeap.poll();
        }
      }

      System.out.println(sum);
    }
  }
}