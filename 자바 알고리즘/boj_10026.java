import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10026 {
/*
<적록색약이 아닌 사람>
current 색을 기준으로 상하좌우 조회 -> 같은 색인 영역으로 이동 -> 재귀 탐색
다른 색이면 current 색 갱신

<적록색약>
색 R-G는 같은 구역
색 구분은 같은 BFS 방식으로 조회함
 */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] colors = new String[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                colors[i][j] = String.valueOf(line.charAt(j));
            }

        }



    }

    private int

}
