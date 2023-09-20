package implementation.example;

import java.util.Arrays;

/* Example05. 로봇의 이동 */
public class Example04 {
    public int[] solution(String moves) {
        // 상하좌우 이동을 나타내는 상대 좌표 배열
        int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
        int[] dc = {0, 1, 0, -1};

        // 초기 위치 (0, 0)와 초기 방향 (1: 동쪽) 설정
        int r = 0; // 초기 행
        int c = 0; // 초기 열
        int d = 1; // 초기 방향 (동쪽)

        // 이동 명령 문자열을 순회
        for (char command : moves.toCharArray()) {
            if (command == 'G') {
                // 'G' 명령인 경우 현재 방향에 따라 이동
                r = r + dr[d]; // 현재 행 위치 업데이트
                c = c + dc[d]; // 현재 열 위치 업데이트
            } else if (command == 'R') {
                // 'R' 명령인 경우 오른쪽으로 회전 (시계방향)
                d = (d + 1) % 4; // 현재 방향을 시계방향으로 변경
            } else if (command == 'L') {
                // 'L' 명령인 경우 왼쪽으로 회전 (반시계방향)
                d = (d + 3) % 4; // 현재 방향을 반시계방향으로 변경
            }
        }

        // 최종적으로 로봇의 위치를 나타내는 배열 반환
        return new int[]{r, c}; // 로봇의 최종 위치를 배열로 반환
    }

    public static void main(String[] args){
        Example04 T = new Example04();
        System.out.println(Arrays.toString(T.solution("GGGRGGG")));
        System.out.println(Arrays.toString(T.solution("GGRGGG")));
        System.out.println(Arrays.toString(T.solution("GGGGGGGRGGGRGGRGGGLGGG")));
        System.out.println(Arrays.toString(T.solution("GGLLLGLGGG")));
    }
}