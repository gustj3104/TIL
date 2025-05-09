import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_25707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] beads = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            beads[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(beads);

        // 줄의 길이 구하기
        int total = 0;
        for (int i = 0; i < n - 1; i++) {
            total += Math.abs(beads[i] - beads[i + 1]);
        }

        // 원형으로 이어주기
        total += Math.abs(beads[0] - beads[n - 1]);
        System.out.println(total);
    }
}

/*
N개의 구술 -> 각 구슬에는 서로 다른 수가 하나씩 적힘
구슬 사이의 줄 길이 = 구슬 차의 절댓값 -> 필요한 줄의 최소 길이 구하기
정렬 -> 두 번째 요소랑 끝 요소를 이어주기
 */
