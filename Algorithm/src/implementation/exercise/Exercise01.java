package implementation.exercise;

/* 프로그래머스 Lv.0 - 안전지대 */
public class Exercise01 {
    public int solution(int[][] board) {
        int n = board.length; // 배열의 한 변의 길이 (보드의 크기)
        int answer = n * n; // 전체 지도 크기를 구한다. (모든 지점을 안전 지대로 가정)

        // 8방향을 탐색하기 위한 상대적인 행과 열의 이동 상수 배열
        int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}; // 상, 상우, 우, 하우, 하, 하좌, 좌, 상좌
        int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

        int cnt = 0; // 안전한 지대 개수를 세기 위한 변수

        // 이중 반복문을 사용하여 배열을 순회
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 1) { // 현재 위치가 위험한 지대인 경우
                    cnt++; // 안전하지 않으므로 cnt를 증가시킨다.

                    // 8방향을 탐색하여 안전한 지대를 찾는다.
                    for (int k = 0; k < 8; k++) {
                        int nr = r + dr[k]; // 다음 행 위치
                        int nc = c + dc[k]; // 다음 열 위치

                        // 다음 위치가 배열 범위 내에 있고, 해당 방향으로 안전한 지대(0)인 경우
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && board[nr][nc] == 0) {
                            cnt++; // 안전하지 않으므로 cnt를 증가시키고
                            board[nr][nc] = 2; // 해당 지대를 방문했음을 표시한다.
                        }
                    }
                }
            }
        }

        // 전체 지대 개수에서 안전하지 않은 지대의 개수를 뺀 결과를 반환한다.
        return answer - cnt;
    }
}