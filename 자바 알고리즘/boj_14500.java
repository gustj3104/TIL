import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14500 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M =Integer.parseInt(st.nextToken());
    int[][] paper = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++) {
        paper[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int max = 0;
    for (int i = 0; i < 4; i++) {
      max = Math.max(max, getMax(paper));
      max = Math.max(max, getMax(flip(paper)));
      paper = rotate(paper);
    }

    System.out.println(max);

  }

  // 좌우 대칭 회전
  public static int[][] flip(int[][] origin) {
    int r = origin.length;
    int c = origin[0].length;
    int[][] flipped = new int[r][c];
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        flipped[i][j] = origin[i][c - 1 - j];
      }
    }
    return flipped;
  }

  // 90도 회전
  public static int[][] rotate(int[][] origin) {
    int r = origin.length;
    int c = origin[0].length;

    // 회전 후 배열은 M×r
    int[][] rotated = new int[c][r];

    for (int i = 0; i < c; i++) {
      for (int j = 0; j < r; j++) {
        rotated[i][j] = origin[r - 1 - j][i];
      }
    }
    return rotated;
  }

  public static int first_t(int[][] paper) {
    int max = 0;
    for (int i = 0; i < paper.length; i++) {
      for (int j = 0; j < paper[i].length; j++) {
        if (j + 3 < paper[i].length) {
          int sum = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i][j + 3];
          if (sum > max) max = sum;
        }
      }
    }
    return max;
  }

  public static int second_t(int[][] paper) {
    int max = 0;
    for (int i = 0; i < paper.length; i++) {
      for (int j = 0; j < paper[i].length; j++) {
        if (j + 1 < paper[i].length && i + 1 < paper.length) {
          int sum = paper[i][j] + paper[i][j + 1] + paper[i + 1][j] + paper[i + 1][j + 1];
          if (sum > max) max = sum;
        }
      }
    }
    return max;
  }

  public static int third_t(int[][] paper) {
    int max = 0;
    for (int i = 0; i < paper.length; i++) {
      for (int j = 0; j < paper[i].length; j++) {
        if (i + 2 < paper.length && j + 1 < paper[i].length) {
          int sum = paper[i][j] + paper[i+1][j] + paper[i + 2][j] + paper[i + 2][j + 1];
          if (sum > max) max = sum;
        }
      }
    }
    return max;
  }

  public static int fourth_t(int[][] paper) {
    int max = 0;
    for (int i = 0; i < paper.length; i++) {
      for (int j = 0; j < paper[i].length; j++) {
        if (j + 1 < paper[i].length && i + 2 < paper.length) {
          int sum = paper[i][j] + paper[i+1][j] + paper[i + 1][j + 1] + paper[i + 2][j + 1];
          if (sum > max) max = sum;
        }
      }
    }
    return max;
  }

  public static int fifth_t(int[][] paper) {
    int max = 0;
    for (int i = 0; i < paper.length; i++) {
      for (int j = 0; j < paper[i].length; j++) {
        if (j + 2 < paper[i].length && i + 1 < paper.length) {
          int sum = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j + 1];
          if (sum > max) max = sum;
        }
      }
    }
    return max;
  }

  private static int getMax(int[][] paper) {
    int m = 0;
    m = Math.max(m, first_t(paper));
    m = Math.max(m, second_t(paper));
    m = Math.max(m, third_t(paper));
    m = Math.max(m, fourth_t(paper));
    m = Math.max(m, fifth_t(paper));
    return m;
  }

}
