package hash.exercise;

import java.util.HashMap;

/* 프로그래머스 Lv.1 - 추억 점수 */
public class Exercise03 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 결과를 저장할 배열 생성
        int[] answer = new int[photo.length];

        // 이름과 그에 해당하는 열망 점수를 매핑하기 위한 HashMap 생성
        HashMap<String, Integer> sH = new HashMap<>();

        // 이름과 열망 점수를 HashMap에 등록
        for (int i = 0; i < name.length; i++) {
            sH.put(name[i], yearning[i]);
        }

        // 각각의 사진에 대해 열망 점수를 계산하고 결과 배열에 저장
        for (int i = 0; i < photo.length; i++) {
            int score = 0;

            // 사진의 각 이름에 대해 열망 점수를 가져와 더함
            for (String x : photo[i]) {
                score += sH.getOrDefault(x, 0);
            }

            // 계산된 열망 점수를 결과 배열에 저장
            answer[i] = score;
        }

        // 결과 배열 반환
        return answer;
    }
}
