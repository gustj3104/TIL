import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int up = Integer.parseInt(st.nextToken()); // 사다리 수
        int down = Integer.parseInt(st.nextToken()); // 뱀 수

        int[] move = new int[101]; // move[i] = j → i에서 j로 이동
        for (int i = 1; i <= 100; i++) {
            move[i] = i; // 기본은 제자리
        }

        for (int i = 0; i < up; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            move[from] = to; // 사다리
        }

        for (int i = 0; i < down; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            move[from] = to; // 뱀
        }

        boolean[] visited = new boolean[101];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0}); // 위치 , 주사위 횟수
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int pos = now[0];
            int count = now[1];

            if (pos == 100) { // 100번 칸 도착
                System.out.println(count);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = pos + i;
                if (next > 100) continue;

                next = move[next]; // 사다리, 뱀 이동
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, count + 1});
                }

            }
        }
    }
}

