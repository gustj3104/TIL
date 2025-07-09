import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_9019 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int target = Integer.parseInt(st.nextToken());

      System.out.println(bfs(start, target));
    }
  }

  private static String bfs(int start, int target) {
    boolean[] visited = new boolean[10000];
    Queue<Pair> queue = new LinkedList<>();

    queue.add(new Pair(start, ""));
    visited[start] = true;

    while (!queue.isEmpty()) {
      Pair current = queue.poll();
      int num = current.num;

      if (num == target) {
        return current.cmd;
      }

      int D = (num * 2) % 10000;
      int S = (num == 0) ? 9999 : num - 1;
      int L = (num % 1000) * 10 + num / 1000;
      int R = (num % 10) * 1000 + num / 10;

      if (!visited[D]) {
        visited[D] = true;
        queue.add(new Pair(D, current.cmd + "D"));
      }

      if (!visited[S]) {
        visited[S] = true;
        queue.add(new Pair(S, current.cmd + "S"));
      }

      if (!visited[L]) {
        visited[L] = true;
        queue.add(new Pair(L, current.cmd + "L"));
      }

      if (!visited[R]) {
        visited[R] = true;
        queue.add(new Pair(R, current.cmd + "R"));
      }
    }

    return "";
  }

  static class Pair {
    int num;
    String cmd;

    Pair(int num, String cmd) {
      this.num = num;
      this.cmd = cmd;
    }
  }
}

