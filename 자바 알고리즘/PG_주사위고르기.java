import java.util.*;
public class PG_주사위고르기 {

  class Solution {
    public int[] solution(int[][] dice) {
      int n = dice.length;
      int k = n/2;
      List<int[]> comb = new ArrayList<>(); // A 주사위 조합

      // 가능한 모든 조합 생성
      generateComb(n, k, 0, new int[k], comb);
      long maxWin = -1;
      int[] maxComb = null;

      // 각 조합마다 A의 승리 수 계산
      for(int[] aIndex : comb){
        // B조합 생성
        Set<Integer> setA = new HashSet<>();
        for(int a : aIndex) setA.add(a); // A가 선택한 인덱스

        int[] bIndex = new int[k];
        int bi = 0;
        // A 인덱스 제외하고 B 인덱스로 설정
        for (int i = 0; i < n; i++){
          if(!setA.contains(i)){
            bIndex[bi++] = i;
          }
        }

        // A, B 합 분포
        //A가 선택한 k개의 주사위 합 분포
        long[] distA = computeDistribution(dice, aIndex);
        // B가 선택한 k개의 주사위 합 분포
        long[] distB = computeDistribution(dice, bIndex);

        // B 누적합
        int maxLen = Math.max(distA.length, distB.length);
        long[] sumB = new long[maxLen];
        long running = 0;
        for (int s = 0; s < maxLen; s++){
          sumB[s] = running; // 합 < s인 모든 경우의 수
          if (s < distB.length) {
            running += distB[s]; // B에서 합 == s 인 경우의 수 누적
          }
        }

        // A가 승리하는 경우
        long winCount = 0;
        for (int s = 0; s < distA.length; s++){
          winCount += distA[s] * sumB[s];
        }

        if (winCount > maxWin){
          maxWin = winCount;
          maxComb = Arrays.copyOf(aIndex, k);
        }
      }

      int[] answer = new int[k];
      for (int i = 0; i < k; i++){
        answer[i] = maxComb[i] + 1;
      }
      Arrays.sort(answer);
      return answer;
    }

    private long[] computeDistribution(int[][] dice, int[] idxs) {
      // 첫 번째 주사위의 실제 최대 면값을 구해서 dist 크기 결정
      int maxFace0 = Arrays.stream(dice[idxs[0]]).max().getAsInt();
      long[] dist = new long[maxFace0 + 1];
      // 첫 번째 주사위 분포 초기화
      for (int v : dice[idxs[0]]) {
        dist[v]++;
      }

      // 나머지 주사위마다 컨볼루션
      for (int i = 1; i < idxs.length; i++) {
        int[] die = dice[idxs[i]];
        // 이번 주사위의 최대 면값
        int maxFace = Arrays.stream(die).max().getAsInt();
        // 새로운 최대 합 = 이전 최대합(dist.length-1) + 이번 주사위 최대 면값
        int newMax = dist.length - 1 + maxFace;
        long[] next = new long[newMax + 1];

        // 모든 (이전 합, 새 면값) 쌍을 더해 next에 누적
        for (int sum = 0; sum < dist.length; sum++) {
          if (dist[sum] == 0) continue;
          for (int face : die) {
            next[sum + face] += dist[sum];
          }
        }
        dist = next;
      }

      return dist;
    }


    // start : 시작 인덱스, buffer: 현재 선택 버퍼
    private void generateComb(int n, int k, int start, int[] buffer, List<int[]> output){
      if(k == 0){
        output.add(buffer.clone());
        return;
      }

      for (int i = start; i<= n-k; i++){
        buffer[buffer.length - k] = i;
        generateComb(n, k - 1, i + 1, buffer, output);
      }
    }
  }

}
