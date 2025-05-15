import java.util.*;

class Solution {

    // 각 노드의 간선 수 (자식 수)
    private int[] inDegree;
    // 부모 배열
    private int[] parent;

    public int[] solution(int[] nodes, int[][] edges) {
        int[] answer = {};

        int lastNode = 0;
        for(int node:nodes){
            lastNode = Math.max(lastNode, node);
        }

        inDegree = new int[lastNode + 1];
        parent = new int[lastNode + 1];
        for (int i = 1; i <= lastNode; i++) {
            parent[i] = i;
        }

        // 두 노드 연결, 차수 + 1
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            inDegree[a]++;
            inDegree[b]++;

            // 같은 트리 그룹으로 묶기
            merge(a, b);
        }

        Map<Integer, TreeInfo> Map = new HashMap<>();
        for (int node : nodes) {
            // 어떤 트리 그룹인지 저장
            int group = find(node);

            TreeInfo t = Map.getOrDefault(group, new TreeInfo());

            // 트리 후보별 조건 검사, 카운트
            if ((node % 2 == 0) && (inDegree[node] % 2 == 0)) {
                t.evenNode++;
            } else if ((node % 2 == 1) && (inDegree[node] % 2 == 1)) {
                t.oddNode++;
            } else if ((node % 2 == 0) && (inDegree[node] % 2 == 1)) {
                t.reverseEvenNode++;
            } else if ((node % 2 == 1) && (inDegree[node] % 2 == 0)) {
                t.reverseOddNode++;
            }

            Map.put(group, t);
        }

        int tree = 0;
        int rTree = 0;

        // 전체 트리에서 조건 검사, 카운트
        for (TreeInfo treeInfo : Map.values()) {
            if (treeInfo.isTree()) {
                tree++;
            }

            if (treeInfo.isReverseTree()) {
                rTree++;
            }
        }

        return new int[]{tree, rTree};


    }

    public class TreeInfo {
        public int oddNode;
        public int evenNode;
        public int reverseOddNode;
        public int reverseEvenNode;

        public TreeInfo(){
            this.oddNode = 0;
            this.evenNode = 0;
            this.reverseOddNode = 0;
            this.reverseEvenNode = 0;
        }

        // 홀짝 트리 조건
        public boolean isTree(){
            if ((oddNode == 1 && evenNode == 0) || (oddNode == 0 && evenNode == 1)) {
                return true;
            }
            return false;
        }

        // 역홀짝 트리 조건
        public boolean isReverseTree(){
            if ((reverseOddNode == 1 && reverseEvenNode == 0) || reverseOddNode == 0 && reverseEvenNode == 1) {
                return true;
            }

            return false;
        }
    }


    public int find(int num) {
        if (parent[num] == num) return num;
        return parent[num] = find(parent[num]);
    }

    public void merge(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }
}
