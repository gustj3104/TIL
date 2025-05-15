import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_10026 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] colors = new char[n][n];
        char[][] revColors = new char[n][n]; // 적록색약 배열

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = line.charAt(j);
                colors[i][j] = c;
                revColors[i][j] = (c == 'G') ? 'R' : c;
            }
        }

        System.out.printf("%d %d", count(colors, n), count(revColors, n));
    }

    // 구역 수 계산
    private static int count(char[][] colors, int n) {
        boolean[][] visited = new boolean[n][n];
        int[][] directions = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };
        int regionCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(colors, visited, i, j, n, directions);
                    regionCount++;
                }
            }
        }
        return regionCount;
    }

    private static void bfs(char[][] colors, boolean[][] visited, int x, int y, int n, int[][] directions) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        char target = colors[x][y];

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int cx = pos[0], cy = pos[1];

            for (int[] d : directions) {
                int nx = cx + d[0];
                int ny = cy + d[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n &&
                        !visited[nx][ny] && colors[nx][ny] == target) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
