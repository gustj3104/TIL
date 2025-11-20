package final_assign.result;

/**
 * 최소 개수의 블록을 골라서 최대 면적 덮기
 * 왼쪽 endpoint 기준 오름차순 정렬 -> greedy algorithm
 * interval cover에 넣을지 말지
 *  - 아직 커버 안된 곳보다 앞선 startpoint가 있는 블록들 -> 후보군
 *  - 오른쪽 끝이 가장 멀리 있는 것 -> 최종 선택
 *
 */
public class MinimumIntervalCover {
// Interval (start, end)를 가진 객체
    /** start 기준 오름차순 정렬
     * compareTo 오버라이드 -> this.start - p.start 비교
     * Arrays.sort 수행 시 수정한 비교방식을 기준으로 정렬됨 = start 기준 정렬
    */

    /** 현재 포인트 선택
     * i -> intervals를 하나씩 탐색할 때 사용할 인덱스
     * cur = 커버를 시작할 스타트점
     * reach = 커버가 될 끝지점
     * cur---reach까지 커버됨 -> reach가 가장 커질 interval을 선택해야 함
     * 더이상 볼 interval이 없거나, cur보다 start가 큰 경우
     *      cur --- start면 지금 커버해야될 지점을 벗어난 interval이라는 의미
     * 마지막에 cur을 reach로 업데이트
     */

    /** union끼리 떨어져있는 경우 예외처리
     * cur보다 다음 블록의 왼쪽 start가 더 크면 무한루프
     * cur = Math.max(cur, intervals[i].start)
     *  :cur = 현재 시작점, cur 중 더 큰값 선택
     */
}