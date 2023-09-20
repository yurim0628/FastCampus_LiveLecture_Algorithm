package hash.example;

import java.util.HashMap;
import java.util.Arrays;

/* Example03. 같은 빈도수 만들기 */
public class Example03 {
    public int[] solution(String s) {
        // 결과를 저장할 배열 초기화 (5개의 원소를 저장할 배열)
        int[] answer = new int[5];

        // 문자의 등장 횟수를 저장하기 위한 HashMap 생성
        HashMap<Character, Integer> sH = new HashMap<>();

        // 문자열을 순회하며 각 문자의 등장 횟수를 저장
        for (char x : s.toCharArray()) {
            // HashMap에 이미 문자가 등록되어 있다면, 해당 문자의 등장 횟수를 1 증가시킴
            // 등록되어 있지 않다면, 0을 기본값으로 설정하고 1을 더함
            sH.put(x, sH.getOrDefault(x, 0) + 1);
        }

        int max = Integer.MIN_VALUE; // 가장 많이 등장한 문자의 등장 횟수를 저장하는 변수

        // 비교할 문자열 "abcde"를 순회하며 가장 많이 등장한 문자의 등장 횟수를 찾음
        String tmp = "abcde";
        for (char key : tmp.toCharArray()) {
            // HashMap에서 해당 문자의 등장 횟수를 가져와서 최댓값을 찾음
            if (sH.getOrDefault(key, 0) > max) {
                max = sH.getOrDefault(key, 0);
            }
        }

        for (int i = 0; i < tmp.length(); i++) {
            // "abcde" 문자열에 각 문자의 등장 횟수를 최댓값에서 뺀 값을 결과 배열에 저장
            answer[i] = max - sH.getOrDefault(tmp.charAt(i), 0);
        }

        return answer; // 결과 배열 반환
    }

    public static void main(String[] args) {
        Example03 T = new Example03();
        System.out.println(Arrays.toString(T.solution("aaabc"))); // [2, 2, 1, 0, 1] 반환
        System.out.println(Arrays.toString(T.solution("aabb")));  // [2, 2, 2, 2, 2] 반환
        System.out.println(Arrays.toString(T.solution("abcde"))); // [0, 0, 0, 0, 0] 반환
        System.out.println(Arrays.toString(T.solution("abcdeabc"))); // [2, 2, 1, 1, 1] 반환
        System.out.println(Arrays.toString(T.solution("abbccddee"))); // [2, 2, 2, 2, 2] 반환
    }
}
