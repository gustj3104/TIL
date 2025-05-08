import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11971 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] rule = new int[m][2];
        int[][] yj = new int[n][2];

        // 도로 길이, 제한 속도 배열 생성
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int road = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            rule[i][0] = road;
            rule[i][1] = speed;
        }

        // 연정이의 구간, 속도 배열 생성
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int road = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            yj[i][0] = road;
            yj[i][1] = speed;
        }

        int maxSpeed = 0;
        int ruleIdx = 0;
        int yjIdx = 0;

        while (ruleIdx < m && yjIdx < n) {
            int ruleLen = rule[ruleIdx][0];
            int ruleSpd = rule[ruleIdx][1];
            int yjLen = yj[yjIdx][0];
            int yjSpd = yj[yjIdx][1];

            int minLen = Math.min(ruleLen, yjLen);

            if (yjSpd > ruleSpd) {
                maxSpeed = Math.max(maxSpeed, yjSpd - ruleSpd);
            }

            rule[ruleIdx][0] -= minLen;
            yj[yjIdx][0] -= minLen;

            if (rule[ruleIdx][0] == 0) ruleIdx++;
            if (yj[yjIdx][0] == 0) yjIdx++;
        }


        System.out.println(maxSpeed);

    }
}

/*
도로 100km
도로길이/제한속도(시속)
1. 40/75
2. 50/35
3. 10/45
=> 속도를 위반한 최댓값 구하기

1. N개 줄에서 구간 길이,제한 속도 입력받아서 2차원 배열 생성
2. M개 줄에서 연정이의 구간 길이, 속도 입력받아서 2차원 배열 생성
3. 달리고 있는 누적 길이로 구간 비교 -> 구간 내에서 연정이의 속도가 제한 속도보다 빠르면 max와 비교해서 갱신
4. max 출력

 */