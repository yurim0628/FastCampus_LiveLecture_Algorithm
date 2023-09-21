package stack_queue_heap.exercise;

import java.util.*;

/* 프로그래머스 Lv.1 - 크레인 인형 뽑기 */
class Exercise01 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0; // 결과로 반환할 인형이 사라진 횟수
        Stack<Integer> stack = new Stack<>(); // 스택을 사용하여 인형을 저장하고 비교

        for (int pos : moves) { // 크레인을 움직이는 각 위치(pos)에 대해서 반복
            for (int i = 0; i < board.length; i++) { // board의 높이(행)만큼 반복
                if (board[i][pos - 1] != 0) { // 해당 위치에 인형이 있으면
                    int tmp = board[i][pos - 1]; // 인형을 뽑아서 tmp에 저장
                    board[i][pos - 1] = 0; // 뽑은 위치의 인형을 0으로 초기화

                    if (!stack.isEmpty() && stack.peek() == tmp) { // 스택이 비어 있지 않고, 스택의 맨 위 인형과 현재 뽑은 인형이 같으면
                        stack.pop(); // 스택에서 맨 위 인형을 제거
                        answer += 2; // 뽑은 두 개의 인형이 터져서 사라지므로 2를 추가하여 사라진 횟수 증가
                    } else {
                        stack.push(tmp); // 스택에 현재 뽑은 인형을 추가
                    }
                    break; // 현재 위치에서 인형을 하나만 뽑아야 하므로 반복문 종료
                }
            }
        }

        return answer; // 최종적으로 사라진 인형의 횟수 반환
    }
}