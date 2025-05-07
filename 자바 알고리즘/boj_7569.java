import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7569 {
    static int countDays(int[][][] farm, int m, int n, int h) {
        Queue<int[]> queue = new LinkedList<>();

        int[][] directions = {
                {-1, 0, 0}, {1, 0, 0}, // x축 이동
                {0, -1, 0}, {0, 1, 0}, // y축 이동
                {0, 0, -1}, {0, 0, 1} // z축 이동
        };

        // 익은 토마토 큐에 추가
        for (int z = 0; z < h; z++) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (farm[z][y][x] == 1) {
                        queue.add(new int[]{z, y, x});
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cz = curr[0], cy = curr[1], cx = curr[2];

            for (int[] dir : directions) {
                int nz = cz + dir[0], ny = cy + dir[1], nx = cx + dir[2];

                // 익지 않은 토마토 익은 상태로 변경
                if (inRange(nz, ny, nx, h, n, m) && farm[nz][ny][nx] == 0) {
                    farm[nz][ny][nx] = farm[cz][cy][cx] + 1; // 일 수 저장
                    queue.add(new int[]{nz, ny, nx});
                }
            }

        }

        // 저장된 일 수 중 최대값 리턴
        int max = 0;
        for (int z = 0; z < h; z++) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (farm[z][y][x] == 0) {
                        return -1;
                    }
                    max = Math.max(max, farm[z][y][x]);
                }
            }
        }

        return max -1;
    }

    static boolean inRange(int z, int y, int x, int h, int n, int m) {
        return z >= 0 && z < h && y >= 0 && y < n && x >= 0 && x < m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int field[][][] = new int[h][n][m];
        for (int z = 0; z < h; z++) { // 높이
            for (int y = 0; y < n; y++) { // 세로
                st = new StringTokenizer(br.readLine(), " ");
                for (int x = 0; x < m; x++) { // 가로
                    field[z][y][x] = Integer.parseInt(st.nextToken());
                }
            }
        }

        System.out.println(countDays(field, m, n, h));

    }
}
