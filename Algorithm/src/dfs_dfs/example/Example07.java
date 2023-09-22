package dfs_dfs.example;

/* Example07. 이진트리 깊이우선탐색 */
class Example07 {
    public void DFS(int v) {
        if (v > 7) // 노드 값이 7보다 크면 함수를 종료하고 이전 호출 스택으로 돌아감
            return;
        else {
            System.out.print(v + " "); // 현재 노드 값을 출력 (전위 순회)
            DFS(v * 2); // 왼쪽 자식 노드로 이동
            DFS(v * 2 + 1); // 오른쪽 자식 노드로 이동
        }
    }

    public static void main(String[] args) {
        Example07 T = new Example07();
        T.DFS(1); // DFS 메서드 호출, 루트 노드에서 시작
    }
}
