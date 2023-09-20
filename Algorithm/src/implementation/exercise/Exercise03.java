package implementation.exercise;

/* 프로그래머스 Lv.1 - 공원 산책 */
public class Exercise03 {
    public int[] solution(String[] park, String[] routes) {
        // 상하좌우 이동을 나타내는 상대 좌표 배열
        int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
        int[] dc = {0, 1, 0, -1};

        // 방향 문자와 상하좌우 문자 배열
        char[] dir = {'N', 'E', 'S', 'W'};

        // 공원의 행과 열의 개수
        int n = park.length; // 행의 개수
        int m = park[0].length(); // 열의 개수

        // 공원 지도를 2차원 문자 배열로 저장
        char[][] board = new char[n][m];
        int r = 0, c = 0; // 시작 위치 초기화

        for (int i = 0; i < n; i++) {
            board[i] = park[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'S') {
                    r = i; // 시작 행
                    c = j; // 시작 열
                }
            }
        }

        for (String tmp : routes) {
            // 이동 명령과 거리를 분리
            char cmd = tmp.split(" ")[0].charAt(0); // 이동 명령 (N, E, S, W)
            int dis = Integer.parseInt(tmp.split(" ")[1]); // 이동 거리
            boolean flag = true; // 이동 가능 여부를 나타내는 플래그
            int nr = 0, nc = 0; // 새로운 위치 변수 초기화

            for (int k = 0; k < 4; k++) {
                if (cmd == dir[k]) {
                    nr = r; // 새로운 행 초기화
                    nc = c; // 새로운 열 초기화

                    for (int i = 0; i < dis; i++) {
                        nr = nr + dr[k]; // 새로운 행 계산
                        nc = nc + dc[k]; // 새로운 열 계산

                        // 범위를 벗어나거나 장애물('X')을 만난 경우 이동 불가능
                        if (nr < 0 || nr >= n || nc < 0 || nc >= m || board[nr][nc] == 'X') {
                            flag = false; // 이동 불가능 플래그 설정
                            break; // 반복 종료
                        }
                    }
                }
            }

            // 이동 가능한 경우에만 위치 업데이트
            if (flag == false) continue;
            r = nr; // 새로운 행으로 업데이트
            c = nc; // 새로운 열으로 업데이트
        }

        // 최종적인 위치를 반환
        return new int[]{r, c};
    }
}