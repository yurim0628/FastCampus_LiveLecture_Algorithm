package hash.exercise;

import java.util.HashMap;

/* 프로그래머스 Lv.1 - 성격 유형 검사하기 */
public class Exercise04 {
    public String solution(String[] survey, int[] choices) {
        // 각 인원의 선택 결과에 따른 두 명의 후보를 나타내는 문자열 배열
        String[] mark = {"RT", "CF", "JM", "AN"};

        // 각 후보에 대한 점수를 저장하기 위한 HashMap 생성
        HashMap<Character, Integer> score = new HashMap<>();

        // 설문 조사 결과를 순회하며 후보에 점수를 부여
        for (int i = 0; i < survey.length; i++) {
            char a = survey[i].charAt(0); // 첫 번째 후보
            char b = survey[i].charAt(1); // 두 번째 후보
            int pos = choices[i] - 4; // 선택한 위치에 따라 점수 변경

            if (pos == 0) continue; // 중립적인 선택이면 점수 변경 없음

            // 후보에 점수를 더하거나 빼줌
            if (pos < 0) {
                score.put(a, score.getOrDefault(a, 0) - pos);
            } else {
                score.put(b, score.getOrDefault(b, 0) + pos);
            }
        }

        // 최종 점수를 비교하여 승자를 결정
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mark.length; i++) {
            char a = mark[i].charAt(0); // 첫 번째 후보
            char b = mark[i].charAt(1); // 두 번째 후보
            int score_a = score.getOrDefault(a, 0); // 첫 번째 후보의 점수
            int score_b = score.getOrDefault(b, 0); // 두 번째 후보의 점수

            // 두 후보의 점수를 비교하여 승자를 결정하고 결과 문자열에 추가
            if (score_a == score_b) {
                sb.append(a); // 점수가 같을 경우 첫 번째 후보 추가
            } else {
                sb.append(score_a > score_b ? a : b); // 높은 점수를 가진 후보 추가
            }
        }

        // 최종 결과 문자열 반환
        return sb.toString();
    }
}
