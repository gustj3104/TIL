import java.util.*;

public class PG_디스크_컨트롤러 {
  static class Solution {
    public int solution(int[][] jobs) {
      // 요청 시각 기준 정렬
      Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));

      // 대기 큐: 작업 소요 시간 기준으로 우선순위 설정
      PriorityQueue<int[]> waitingQ = new PriorityQueue<>(
          Comparator.comparingInt(a -> a[1])
      );

      int time = 0;        // 현재 시간
      int totalRT = 0;     // 총 반환 시간
      int idx = 0;         // jobs 배열 인덱스
      int count = 0;       // 완료된 작업 수

      while (count < jobs.length) {
        // 현재 시간까지 도착한 작업을 모두 큐에 추가
        while (idx < jobs.length && jobs[idx][0] <= time) {
          waitingQ.add(jobs[idx]);
          idx++;
        }

        if (waitingQ.isEmpty()) {
          // 실행할 작업이 없다면 다음 작업 시간으로 점프
          time = jobs[idx][0];
          continue;
        }

        // 가장 짧은 소요시간을 가진 작업 선택
        int[] cur = waitingQ.poll();
        time += cur[1];
        totalRT += (time - cur[0]); // 반환 시간 = 완료 시간 - 요청 시간
        count++;
      }

      return totalRT / jobs.length; // 평균 반환 시간
    }
  }
}
