package dfs_dfs.exercise;

import java.util.*;

/* 프로그래머스 Lv.2 - 게임 맵 최단거리 */
class Exercise01 {
    public int solution(int[][] maps) {
        int n = maps.length; // 지도의 행 수
        int m = maps[0].length; // 지도의 열 수
        int[] dx = {-1, 0, 1, 0}; // 상, 우, 하, 좌 방향을 나타내는 배열
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> Q = new LinkedList<>(); // BFS를 위한 큐(Q) 생성
        Q.offer(new int[]{0, 0}); // 출발 지점을 큐에 추가
        int L = 1; // 경로의 길이(L) 초기화

        while (!Q.isEmpty()) {
            int len = Q.size(); // 현재 큐에 있는 좌표의 수를 저장 (현재 레벨의 노드 수)

            for (int i = 0; i < len; i++) {
                int[] p = Q.poll(); // 큐에서 좌표를 꺼냅니다.

                for (int k = 0; k < 4; k++) {
                    int nx = p[0] + dx[k]; // 다음 행(row) 좌표 계산
                    int ny = p[1] + dy[k]; // 다음 열(column) 좌표 계산

                    if (nx == n - 1 && ny == m - 1) // 목적지에 도달한 경우 경로의 길이(L) + 1 반환
                        return L + 1;

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1) {
                        maps[nx][ny] = 0; // 해당 위치를 방문했음을 표시
                        Q.offer(new int[]{nx, ny}); // 다음 위치를 큐에 추가
                    }
                }
            }
            L++; // 다음 레벨(거리)로 이동
        }
        return -1; // 목적지까지 도달할 수 없는 경우 -1 반환
    }
}