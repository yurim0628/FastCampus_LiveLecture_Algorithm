package implementation.example;

import java.util.Arrays;

/* Example02. 청소 로봇(ver 1) */
public class Example02 {
    // solution 메서드: 청소 로봇의 최종 위치 계산
    public int[] solution(String moves){
        int[] dr = {-1, 0, 1, 0}; // 상, 우, 하, 좌 방향으로 이동하는 행 변화
        int[] dc = {0, 1, 0, -1}; // 상, 우, 하, 좌 방향으로 이동하는 열 변화
        char[] dir = {'U', 'R', 'D', 'L'}; // 이동 명령에 대응하는 문자 배열
        int r = 0; // 로봇의 초기 행 위치
        int c = 0; // 로봇의 초기 열 위치

        // 입력 문자열에서 각 이동 명령을 하나씩 처리
        for(char command : moves.toCharArray()){
            // 이동 명령과 방향 배열을 비교하여 새로운 위치 계산
            for(int k = 0; k < 4; k++){
                if(command == dir[k]){
                    r = r + dr[k]; // 행 위치 업데이트
                    c = c + dc[k]; // 열 위치 업데이트
                }
            }
        }
        // 로봇의 최종 위치를 배열로 반환
        return new int[]{r, c};
    }

    // main 메서드: 테스트용
    public static void main(String[] args){
        Example02 T = new Example02();
        System.out.println(Arrays.toString(T.solution("RRRDDDLU")));
        System.out.println(Arrays.toString(T.solution("DDDRRRDDLL")));
        System.out.println(Arrays.toString(T.solution("RRRRRRDDDDDDUULLL")));
        System.out.println(Arrays.toString(T.solution("RRRRDDDRRDDLLUU")));
    }
}