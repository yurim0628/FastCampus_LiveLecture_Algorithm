package stack_queue_heap.example;

import java.util.*;

/* Example01. 괄호문자제거 */
class Example01 {
    public String solution(String str) {
        StringBuilder sb = new StringBuilder(); // 결과 문자열을 저장하기 위한 StringBuilder 생성
        Stack<Character> stack = new Stack<>(); // 문자를 임시로 저장하기 위한 스택 생성

        // 입력 문자열을 문자 단위로 순회
        for (char x : str.toCharArray()) {
            if (x == ')') { // 현재 문자가 ')'인 경우
                while (stack.pop() != '('); // 스택에서 '('를 만날 때까지 문자를 제거
            } else {
                stack.push(x); // 다른 문자인 경우 스택에 추가
            }
        }

        // 스택에 남아 있는 문자를 결과 문자열에 추가
        for (char x : stack) {
            sb.append(x);
        }

        return sb.toString(); // 결과 문자열 반환
    }

    public static void main(String[] args) {
        Example01 T = new Example01();

        System.out.println(T.solution("(A(BC)D)EF(G(H)(IJ)K)LM(N)"));
    }
}