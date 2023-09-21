package stack_queue_heap.exercise;

import java.util.*;

/* 프로그래머스 Lv.2 - 스킬트리 */
class Exercise02 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0; // 가능한 스킬트리의 개수를 저장하는 변수

        for (String tree : skill_trees) { // 주어진 스킬트리 배열에서 각각의 스킬트리를 확인
            Queue<Character> Q = new LinkedList<>();
            for (char x : skill.toCharArray()) {
                Q.offer(x); // 스킬 문자열을 큐에 넣음
            }
            boolean flag = true; // 스킬 순서가 유효한지를 나타내는 플래그

            for (char x : tree.toCharArray()) { // 스킬트리 문자열을 확인
                if (Q.contains(x)) { // 현재 문자(x)가 스킬 큐에 포함되어 있으면
                    if (x != Q.poll()) { // 현재 스킬 순서가 큐의 맨 앞 스킬과 다르다면
                        flag = false; // 스킬 순서가 유효하지 않으므로 플래그를 false로 설정하고 반복 종료
                        break;
                    }
                }
            }

            if (flag) { // 스킬 순서가 유효하다면
                answer++; // 가능한 스킬트리의 개수를 증가
            }
        }

        return answer; // 가능한 스킬트리의 총 개수를 반환
    }
}