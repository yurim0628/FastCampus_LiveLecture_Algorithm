package hash.example;

import java.util.HashMap;

/* Example04. 팰린드롬의 길이 */
class Example04 {
    public int solution(String s) {
        int answer = 0; // 결과 값을 저장할 변수

        // 문자의 등장 횟수를 저장하기 위한 HashMap 생성
        HashMap<Character, Integer> sH = new HashMap<>();

        // 문자열을 순회하며 각 문자의 등장 횟수를 저장
        for (char x : s.toCharArray()) {
            // HashMap에 이미 문자가 등록되어 있다면, 해당 문자의 등장 횟수를 1 증가시킴
            // 등록되어 있지 않다면, 0을 기본값으로 설정하고 1을 더함
            sH.put(x, sH.getOrDefault(x, 0) + 1);
        }

        int odd = 0; // 홀수 번 등장하는 문자의 개수를 저장할 변수

        // HashMap의 keySet을 순회하며 문자의 등장 횟수가 홀수인 경우를 카운트
        for (char key : sH.keySet()) {
            if (sH.get(key) % 2 == 1) {
                odd++;
            }
        }

        // 홀수 번 등장하는 문자가 1개 이상인 경우
        if (odd > 0) {
            // 결과 값은 전체 문자열 길이에서 홀수 번 등장하는 문자 중 하나를 제외한 개수를 더함
            answer = s.length() - odd + 1;
        } else {
            // 홀수 번 등장하는 문자가 없는 경우, 결과 값은 전체 문자열의 길이와 동일
            answer = s.length();
        }

        return answer; // 결과 값을 반환
    }

    public static void main(String[] args) {
        Example04 T = new Example04();
        System.out.println(T.solution("abcbbbccaaeee")); // 13 반환
        System.out.println(T.solution("aabbccddee"));    // 10 반환
        System.out.println(T.solution("fgfgabtetaaaetytceefcecekefefkccckbsgaafffg")); // 49 반환
        System.out.println(T.solution("aabcefagcefbcabbcc")); // 12 반환
        System.out.println(T.solution("abcbbbccaa")); // 8 반환
    }
}