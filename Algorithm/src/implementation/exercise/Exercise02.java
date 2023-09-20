package implementation.exercise;

/* 프로그래머스 Lv.0 - 정수를 나선형으로 배치 */
public class Exercise02 {
    public int[][] solution(int n) {
        // 결과를 저장할 2차원 배열 생성
        int[][] answer = new int[n][n];

        // 상하좌우 방향을 나타내는 상대 좌표 배열
        int[] dr = {-1, 0, 1, 0}; // 상, 우, 하, 좌
        int[] dc = {0, 1, 0, -1};

        // 초기 위치 설정 (0, -1)에서 시작하여 우측으로 이동
        int r = 0; // 초기 행
        int c = -1; // 초기 열
        int d = 1; // 초기 방향 (우측)

        // 배열에 순차적으로 채워질 숫자를 나타내는 변수
        int cnt = 1;

        while (cnt <= n * n) {
            // 다음 위치 계산
            int nr = r + dr[d]; // 다음 행 위치
            int nc = c + dc[d]; // 다음 열 위치

            // 다음 위치가 배열의 범위를 벗어나거나 이미 숫자가 채워진 경우 방향 전환한다.
            if (nr < 0 || nr >= n || nc < 0 || nc >= n || answer[nr][nc] > 0) {
                d = (d + 1) % 4; // 방향을 오른쪽으로 변경한다. (상, 우, 하, 좌 순서)
                continue; // 다음 반복으로 이동
            }

            // 다음 위치에 숫자 채우고, 숫자를 증가시킨다.
            answer[nr][nc] = cnt;
            cnt++;

            // 위치 업데이트
            r = nr;
            c = nc;
        }

        return answer; // 나선형으로 배치된 정수가 채워진 배열 반환
    }
}