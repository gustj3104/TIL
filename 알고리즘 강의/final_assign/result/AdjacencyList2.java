package final_assign.result;

/**
 * directed, weighted graph에서의 인접리스트 구현
 * start end weight 순서로 입력
 *       (weight)
 * start --------> end
 */
public class AdjacencyList2 {
    /**
     * graph[u] -> [v, v.weight] -> [w, w.weight]
     * node_number, weight를 필드로 가진 객체 Edge 생성
     * graph 내부는 ArrayList<Edge> 구조
     *      => graph = ArrayList<Edge>[]
     *
     * graph[u].add(Edge(v, w))로 연결
     *
     * 정렬 (출력용)
     * compareTo 오버라이드 -> Edge의 v 기준 오름차순 정렬로 변경
     */
}
