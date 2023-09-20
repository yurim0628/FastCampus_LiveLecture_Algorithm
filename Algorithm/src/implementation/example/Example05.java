package hash.example;

import java.util.Arrays;

/* Example05. 청소 로봇(ver 3) */
public class Example05 {
    public int[] solution(int[][] board, int k) {
        int[] answer = new int[2]; // 로봇의 최종 위치를 저장할 배열
        int n = board.length; // 보드의 크기 (n x n)
        int[] dr = {-1, 0, 1, 0}; // 상하좌우 이동을 나타내는 상대 좌표 배열
        int[] dc = {0, 1, 0, -1};
        int r = 0, c = 0, d = 1, count = 0; // 로봇의 초기 위치, 초기 방향, 이동 횟수 초기화

        // 로봇의 이동 횟수가 k보다 작을 때까지 반복
        while (count < k) {
            count++; // 이동 횟수 증가
            int nr = r + dr[d]; // 새로운 행 위치 계산
            int nc = c + dc[d]; // 새로운 열 위치 계산

            // 새로운 위치가 보드 범위를 벗어나거나 벽(1)에 부딪히면 방향 전환
            if (nr < 0 || nr >= n || nc < 0 || nc >= n || board[nr][nc] == 1) {
                d = (d + 1) % 4; // 방향을 시계방향으로 전환 (오른쪽으로 회전)
                continue; // 다음 반복으로 이동
            }

            // 새로운 위치로 로봇 이동
            r = nr; // 현재 행 위치 업데이트
            c = nc; // 현재 열 위치 업데이트
        }

        // 최종적으로 로봇의 위치를 나타내는 배열에 저장하여 반환
        answer[0] = r; // 로봇의 행 위치
        answer[1] = c; // 로봇의 열 위치
        return answer;
    }

    public static void main(String[] args){
        Example05 T = new Example05();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}