import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pgs_홀짝트리 {
    class Solution {
        // 노드 번호 , 연결 정보 저장
        Map<Integer, List<Integer>> trees = new HashMap<>();
        boolean[] visited = new boolean[1000001];

        public int[] solution(int[] nodes, int[][] edges) {
            int[] answer = new int[2];
            for (int node : nodes) {
                trees.put(node, new ArrayList<>());
            }

            for (int[] edge : edges) {
                trees.get(edge[0]).add(edge[1]);
                trees.get(edge[1]).add(edge[0]);
            }

            for (int node : nodes) {
                if (visited[node]) {
                    continue;
                }
                // node를 루트로 하는 서브트리 조건 검사
                if (check(node, -1)) {
                    answer[0]++;
                }
            }

            visited = new boolean[1000001];
            for (int node : nodes) {
                if (visited[node]) {
                    continue;
                }
                if (checkReverse(node, -1)) {
                    answer[1]++;
                }
            }

            return answer;
        }

        // 홀짝 트리 화면
        private boolean check(int current, int parent) {
            List<Integer> children = trees.get(current);
            int childrenSize = children.size() - 1; // 연결 노드 중 부모 노드 제외
            if (parent == -1) {
                childrenSize++; // 루트노드는 부모노드가 없으므로 다시 1 더해줌
            }

            if (current % 2 == childrenSize % 2) { // 홀짝 검사
                visited[current] = true;
                for (int child : children) {
                    if (child == parent) continue;
                    if (!check(child, current)) { // 하위 노드가 만족 못하는 경우 실패
                        visited[current] = false; // 방문 취소
                        return false;
                    }
                }
            } else {
                return false;
            }
            return true;
        }

        // 역홀짝 트리 화면
        private boolean checkReverse(int current, int parent) {
            List<Integer> children = trees.get(current);
            int childrenSize = children.size() - 1;
            if (parent == -1) {
                childrenSize++;
            }

            if (current % 2 != childrenSize % 2) {
                visited[current] = true;
                for (int child : children) {
                    if (child == parent) continue;
                    if (!checkReverse(child, current)) {
                        visited[current] = false;
                        return false;
                    }
                }
            } else {
                return false;
            }
            return true;
        }
    }
}
