package Lab03;

import java.io.*;
import java.util.*;

public class ClassroomAssignment {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] classTime = new int[n][2];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) classTime[i][0] = Integer.parseInt(st.nextToken()); // start
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) classTime[i][1] = Integer.parseInt(st.nextToken()); // end

            // 시작시간 기준 정렬
            Arrays.sort(classTime, Comparator.comparingInt(a -> a[0]));

            PriorityQueue<Integer> pq = new PriorityQueue<>(); // 끝시간 최소힙
            int answer = 0;

            for (int i = 0; i < n; i++) {
                int s = classTime[i][0], e = classTime[i][1];

                // s 시각까지 끝난 모든 강의실 반납
                while (!pq.isEmpty() && pq.peek() <= s) pq.poll();

                // 현재 수업을 배정: 끝시간을 기록
                pq.offer(e);

                // 동시에 쓰이는 방 개수의 최댓값 갱신
                if (pq.size() > answer) answer = pq.size();
            }

            System.out.println(answer);
        }
    }
}
