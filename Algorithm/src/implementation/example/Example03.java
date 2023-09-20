package implementation.example;

import java.util.Arrays;

/* Example03. 청소 로봇(ver 2) */
public class Example03 {
    public int[] solution(int n, String moves) {
        // 상하좌우 이동을 나타내는 상대 좌표 배열
        int[] dr = {-1, 0, 1, 0}; // 상, 우, 하, 좌
        int[] dc = {0, 1, 0, -1};

        // 이동 명령 문자와 실제 이동 방향을 매핑하는 배열
        char[] dir = {'U', 'R', 'D', 'L'}; // 상, 우, 하, 좌

        // 현재 로봇의 위치 초기화
        int r = 0; // 초기 행
        int c = 0; // 초기 열

        // 이동 명령 문자열을 순회
        for (char command : moves.toCharArray()) {
            int nr = 0, nc = 0; // 새로운 위치를 나타내는 변수 초기화

            // 이동 명령에 따라 새로운 위치 계산
            for (int k = 0; k < 4; k++) {
                if (command == dir[k]) { // 이동 명령과 매핑된 방향인 경우
                    nr = r + dr[k]; // 새로운 행 계산
                    nc = c + dc[k]; // 새로운 열 계산
                }
            }

            // 새로운 위치가 범위를 벗어나면 무시하고 계속 진행
            if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;

            // 새로운 위치로 업데이트
            r = nr; // 현재 행 업데이트
            c = nc; // 현재 열 업데이트
        }

        // 최종적으로 로봇의 위치를 나타내는 배열 반환
        return new int[]{r, c};
    }

    public static void main(String[] args) {
        Example03 T = new Example03();
        System.out.println(Arrays.toString(T.solution(5, "RRRDDDUUUUUUL")));
        System.out.println(Arrays.toString(T.solution(7, "DDDRRRDDLL")));
        System.out.println(Arrays.toString(T.solution(5, "RRRRRDDDDDU")));
        System.out.println(Arrays.toString(T.solution(6, "RRRRDDDRRDDLLUU")));
    }
}