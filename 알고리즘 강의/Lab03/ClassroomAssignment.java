package Lab03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ClassroomAssignment {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] classTime = new int[n][2];
            // classTime[start_time][end_time]

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                classTime[i][0] = Integer.parseInt(st.nextToken());
            }
            st =  new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                classTime[i][1] = Integer.parseInt(st.nextToken());
            }

            // end-time 기준 오름차순 정렬
            Arrays.sort(classTime, (a, b) -> Integer.compare(a[0], b[0]));

            int time = classTime[0][1]; // 첫 타임 end-time
            int num = 1;
            for (int i = 0; i < 2; i++) {
                if (time <= classTime[i][1]) {
                    time = classTime[i][2];
                    num += 1;
                }
            }
            System.out.println(num);
        }
    }

}

/**
 *
 * 강의별로 강의실 배정
 * 한 타임에 강의실이 겹치게 배정되면 안됨
 * 강의실을 최소 개수
 */