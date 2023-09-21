package stack_queue_heap.example;

import java.util.*;

/* Example02. 연속된 문자 지우기 */
class Example02 {
    public String solution(String s) {
        Stack<Character> stack = new Stack<>();

        // 문자열을 순회하면서 중복 문자 제거
        for (char x : s.toCharArray()) {
            if (!stack.isEmpty() && x == stack.peek()) {
                stack.pop(); // 스택의 맨 위 문자와 현재 문자가 같으면 스택에서 제거
            } else {
                stack.push(x); // 중복되지 않는 문자는 스택에 추가
            }
        }

        StringBuilder sb = new StringBuilder();

        // 스택에 남아 있는 문자를 결과 문자열에 추가
        for (char x : stack) {
            sb.append(x);
        }

        return sb.toString(); // 결과 문자열 반환
    }

    public static void main(String[] args) {
        Example02 T = new Example02();

        System.out.println(T.solution("acbbcaa"));
        System.out.println(T.solution("bacccaba"));
        System.out.println(T.solution("aabaababbaa"));
        System.out.println(T.solution("bcaacccbaabccabbaa"));
        System.out.println(T.solution("cacaabbc"));
    }
}