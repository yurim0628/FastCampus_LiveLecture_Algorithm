package dfs_dfs.example;

import java.util.*;

/* Example03. 미로의 최단거리 통로 */
class Example03 {
    public int solution(int[][] board) {
        int[] dr = {-1, 0, 1, 0}; // 상, 우, 하, 좌 방향을 나타내는 배열
        int[] dc = {0, 1, 0, -1};
        Queue<int[]> Q = new LinkedList<>(); // 2D 좌표를 저장하는 큐(Q) 생성
        Q.offer(new int[]{0, 0}); // 출발지(0, 0)를 큐에 추가
        int L = 0; // 거리(L) 초기화

        // 큐가 비어있지 않을 동안 반복
        while (!Q.isEmpty()) {
            int len = Q.size(); // 현재 큐에 있는 좌표의 수를 저장 (현재 레벨의 노드 수)

            for (int i = 0; i < len; i++) {
                int[] p = Q.poll(); // 큐에서 좌표를 꺼내옵니다.

                for (int k = 0; k < 4; k++) {
                    int nr = p[0] + dr[k]; // 다음 행(row) 좌표 계산
                    int nc = p[1] + dc[k]; // 다음 열(column) 좌표 계산

                    if (nr == 6 && nc == 6) return L + 1; // 목적지(6, 6)에 도달한 경우 거리(L) + 1 반환

                    // 다음 위치가 미로 내에 있고, 아직 방문하지 않았으며, 이동 가능한 곳(0)인 경우 처리합니다.
                    if (nr >= 0 && nr < 7 && nc >= 0 && nc < 7 && board[nr][nc] == 0) {
                        board[nr][nc] = 1; // 해당 위치를 방문했음을 표시
                        Q.offer(new int[]{nr, nc}); // 다음 위치를 큐에 추가
                    }
                }
            }
            L++; // 다음 레벨(거리)로 이동
        }
        return -1; // 목적지까지 도달할 수 없는 경우 -1 반환
    }

    public static void main(String[] args) {
        Example03 T = new Example03();
        int[][] arr = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}
        };
        System.out.println(T.solution(arr)); // 최단 경로 거리 출력
    }
}