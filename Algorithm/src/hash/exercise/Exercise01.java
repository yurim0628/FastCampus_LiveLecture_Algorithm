package hash.exercise;

import java.util.Arrays;
import java.util.HashMap;

/* 프로그래머스 Lv.0 - 한 번만 등장한 문자 */
public class Exercise01 {
    public String solution(String s) {
        // 문자의 등장 횟수를 저장하기 위한 HashMap 생성
        HashMap<Character, Integer> sH = new HashMap<>();

        // 문자열을 순회하며 각 문자의 등장 횟수를 저장
        for (char x : s.toCharArray()) {
            // HashMap에 이미 문자가 등록되어 있다면, 해당 문자의 등장 횟수를 1 증가시킴
            // 등록되어 있지 않다면, 0을 기본값으로 설정하고 1을 더함
            sH.put(x, sH.getOrDefault(x, 0) + 1);
        }

        // 등장 횟수가 1인 문자들을 저장하기 위한 StringBuilder 생성
        StringBuilder sb = new StringBuilder();

        // HashMap의 keySet을 순회하며 등장 횟수가 1인 문자를 StringBuilder에 추가
        for (char key : sH.keySet()) {
            if (sH.get(key) == 1) {
                sb.append(key);
            }
        }

        // StringBuilder에 저장된 문자들을 정렬하여 문자열로 변환
        String tmp = sb.toString();
        char[] answer = tmp.toCharArray();
        Arrays.sort(answer);

        // 정렬된 문자열을 반환
        return String.valueOf(answer);
    }
}
