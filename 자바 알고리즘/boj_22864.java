import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_22864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = 0; int b = 0; int c = 0; int m = 0;
        while (st.hasMoreTokens()) {
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
        }


        int totalHard = 0; // 누적 피로도
        int totalWork = 0; // 누적 일
        int time = 24;

        while (time > 0) {
            time -= 1;
            if ((totalHard + a <= m)) {
                totalWork += b;
                totalHard += a;
            } else {
                if (totalHard - c < 0) {
                    totalHard = 0;
                } else {
                    totalHard -= c;
                }
            }
        }

        System.out.println(totalWork);
    }
}

/*
하루 한 시간 일 = A 피로도, B 일 처리
한 시간 휴식 = C 피로도 감소(음수가 되면 0으로 세팅)
M 넘지않게 일 -> 24시간동안 최대 얼마나 일이 가능한지 계산

while (time > 0)
피로도 누적 + A가 M을 넘지 않으면
누적 일 처리 + B
넘으면 누적 피로도 - C
 */