package hash.example;

import java.util.HashMap;

/* Example01. 학급회장 */
public class Example01 {
    public char solution(String s) {
        char answer = ' ';

        // 문자와 그 등장 횟수를 저장하기 위한 HashMap 생성
        HashMap<Character, Integer> map = new HashMap<>();

        // 문자열을 순회하며 각 문자의 등장 횟수를 저장
        for (char x : s.toCharArray()) {
            // HashMap에 이미 문자가 등록되어 있다면, 해당 문자의 등장 횟수를 1 증가시킴
            // 등록되어 있지 않다면, 0을 기본값으로 설정하고 1을 더함
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int max = Integer.MIN_VALUE; // 가장 많이 등장한 문자의 등장 횟수를 저장하는 변수

        // HashMap을 순회하며 가장 많이 등장한 문자를 찾음
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key; // 가장 많이 등장한 문자를 answer에 저장
            }
        }

        return answer; // 가장 많이 등장한 문자 반환
    }

    public static void main(String[] args) {
        Example01 T = new Example01();
        System.out.println(T.solution("BACBACCACCBDEDE"));
        System.out.println(T.solution("AAAAABBCCDDDD"));
        System.out.println(T.solution("AABBCCDDEEABCB"));
    }
}
