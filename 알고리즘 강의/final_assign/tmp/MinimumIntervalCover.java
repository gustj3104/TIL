package final_assign.tmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 최소 개수의 블록을 골라서 최대 면적 덮기
 * 왼쪽 endpoint 기준 오름차순 정렬 -> greedy algorithm
 * interval cover에 넣을지 말지
 *  - 아직 커버 안된 곳보다 앞선 startpoint가 있는 블록들 -> 후보군
 *  - 오른쪽 끝이 가장 멀리 있는 것 -> 최종 선택
 *
 */
public class MinimumIntervalCover {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] l = new int[n];
            int[] r = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                l[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                r[i] = Integer.parseInt(st.nextToken());
            }

            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = l[i];
                intervals[i][1] = r[i];
            }

            // intervals를 0행 기준 오름차순 정렬
            Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));

            int block = 0; // 검토한 총 블록 수
            int selectBlock = 0; // 선택한 총 블록 수
            // 현재 포인트 기준 왼쪽 블록을 후보군으로
            int curr = 0;
            while (block < n) {
                ArrayList<Integer> candidate = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (intervals[i][0] <= curr) {
                        candidate.add(intervals[i][0]);
                        block++;
                    }
                }

                // 오른쪽 끝이 가장 먼 블록 선택
                int last = 0;
                for (int i = 0; i < candidate.toArray().length; i++) {
                    if (candidate[i] > last) {
                        last = candidate[i];
                        selectBlock++;
                    }
                }

                // 현재 위치 업데이트
                curr = last;

                if (candidate.isEmpty() && block != n) {
                    curr = intervals[block++][0];
                }
            }
            System.out.println(selectBlock);

        }
    }
}
