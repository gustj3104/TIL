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

        int[] limit = new int[100];
        int[] yj = new int[100];

        int idx = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            for (int j = 0; j < len; j++) {
                limit[idx++] = speed;
            }
        }

        idx = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            for (int j = 0; j < len; j++) {
                yj[idx++] = speed;
            }
        }

        int maxOver = 0;
        for (int i = 0; i < 100; i++) {
            if (yj[i] > limit[i]) {
                maxOver = Math.max(maxOver, yj[i] - limit[i]);
            }
        }

        System.out.println(maxOver);
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