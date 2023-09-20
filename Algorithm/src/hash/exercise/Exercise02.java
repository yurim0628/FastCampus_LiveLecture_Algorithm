package hash.exercise;

import java.util.Arrays;
import java.util.HashMap;

/* 프로그래머스 - 외톨이 알파벳 */
public class Exercise02 {
    public String solution(String input_string) {
        String answer = "";

        // 문자의 등장 횟수를 저장하기 위한 HashMap 생성
        HashMap<Character, Integer> sH = new HashMap<>();

        // 첫 번째 문자를 HashMap에 등록하고 초기 등장 횟수를 1로 설정
        sH.put(input_string.charAt(0), 1);

        // 문자열을 순회하며 연속으로 같은 문자를 카운트
        for (int i = 1; i < input_string.length(); i++) {
            // 현재 문자와 이전 문자가 다르다면,
            if (input_string.charAt(i - 1) != input_string.charAt(i)) {
                // HashMap에 현재 문자를 등록하고, 기존 등장 횟수에 1을 더함
                sH.put(input_string.charAt(i), sH.getOrDefault(input_string.charAt(i), 0) + 1);
            }
        }

        // 등장 횟수가 2 이상인 문자들을 저장하기 위한 StringBuilder 생성
        StringBuilder sb = new StringBuilder();

        // HashMap의 keySet을 순회하며 등장 횟수가 2 이상인 문자를 StringBuilder에 추가
        for (char key : sH.keySet()) {
            if (sH.get(key) >= 2) {
                sb.append(key);
            }
        }

        // 등장 횟수가 2 이상인 문자들을 정렬하여 문자열로 변환
        answer = sb.toString();

        // 등장 횟수가 2 이상인 문자가 없다면 "N" 반환
        if (answer.equals("")) {
            return "N";
        }

        // 정렬된 문자열을 반환
        char[] tmp = answer.toCharArray();
        Arrays.sort(tmp);
        answer = String.valueOf(tmp);
        return answer;
    }
}
