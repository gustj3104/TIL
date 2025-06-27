import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1002 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int r1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      int r2 = Integer.parseInt(st.nextToken());

      int dx = x2 - x1;
      int dy = y2 - y1;

      // 두 원의 중심 간 거리
      int distance = dx * dx + dy * dy;

      int rSum = r1 + r2;
      int rDiff = Math.abs(r1 - r2);

      if (distance == 0 && r1 == r2) {
        System.out.println(-1);  // 겹침
      } else if (distance == rSum * rSum || distance == rDiff * rDiff) {
        System.out.println(1);   // 내접 또는 외접
      } else if (rDiff * rDiff < distance && distance < rSum * rSum) {
        System.out.println(2);   // 두 점에서 만남
      } else {
        System.out.println(0);   // 만나지 않음
      }
    }
  }
}
