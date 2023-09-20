package hash.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* 프로그래머스 Lv.1 - 신고결과받기 */
public class Exercise05 {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 결과 배열 초기화
        int[] answer = new int[id_list.length];

        // 신고 내역을 저장하는 HashMap
        HashMap<String, HashSet<String>> reportHash = new HashMap<>();

        // 사용자가 몇 번 신고당했는지 저장하는 HashMap
        HashMap<String, Integer> stoped = new HashMap<>();

        // 중복 신고를 제거하기 위한 HashSet 생성
        HashSet<String> reportSet = new HashSet<>(Arrays.asList(report));

        // 중복을 제거한 신고 내역을 순회하며 정보 추출 및 저장
        for (String x : reportSet) {
            // 신고한 사용자와 대상 사용자를 추출
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];

            // 대상 사용자를 신고한 내역을 해당 사용자의 신고 목록에 추가
            reportHash.putIfAbsent(a, new HashSet<String>());
            reportHash.get(a).add(b);

            // 대상 사용자의 신고 횟수를 저장
            stoped.put(b, stoped.getOrDefault(b, 0) + 1);
        }

        // 각 사용자에 대해 처리
        for (int i = 0; i < id_list.length; i++) {
            int cnt = 0;

            // 해당 사용자가 신고한 사용자 목록이 없으면 다음 사용자로 이동
            if (reportHash.get(id_list[i]) == null) continue;

            // 해당 사용자가 신고한 사용자 목록을 순회하며 처리
            for (String user : reportHash.get(id_list[i])) {
                // 대상 사용자가 k번 이상 신고당한 경우
                if (stoped.get(user) >= k) {
                    cnt++;
                }
            }

            // 결과 배열에 결과 저장
            answer[i] = cnt;
        }

        // 결과 배열 반환
        return answer;
    }
}