package hash.example;

import java.util.HashMap;

/* Example02. 한 번 사용한 최초문자 */
public class Example02 {
    public int solution(String s) {
        HashMap<Character, Integer> sH = new HashMap<>();

        // 문자열을 순회하며 각 문자의 등장 횟수를 저장하기 위한 HashMap 생성
        for (char x : s.toCharArray()) {
            // HashMap에 이미 문자가 등록되어 있다면, 해당 문자의 등장 횟수를 1 증가시킴
            // 등록되어 있지 않다면, 0을 기본값으로 설정하고 1을 더함
            sH.put(x, sH.getOrDefault(x, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            // 문자열을 순회하며 각 문자의 등장 횟수를 확인
            if (sH.get(s.charAt(i)) == 1) {
                // 등장 횟수가 1인 문자를 찾으면 해당 문자의 위치를 반환
                return i + 1; // 위치는 1부터 시작하므로 i에 1을 더함
            }
        }

        // 등장 횟수가 1인 문자가 없는 경우 -1을 반환
        return -1;
    }

    public static void main(String[] args) {
        Example02 T = new Example02();
        System.out.println(T.solution("statitsics"));
        System.out.println(T.solution("aabb"));
        System.out.println(T.solution("stringshowtime"));
        System.out.println(T.solution("abcdeabcdfg"));
    }
}
