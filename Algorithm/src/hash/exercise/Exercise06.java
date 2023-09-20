package hash.exercise;

import java.util.ArrayList;

/* 프로그래머스 Lv.2 - 주차 요금 계산 */
public class Exercise06 {
    // 주어진 시간 문자열을 분 단위로 변환하는 메서드
    public int getTime(String time) {
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return H * 60 + M; // 시간을 분으로 환산하여 반환
    }

    public int[] solution(int[] fees, String[] records) {
        // 차량 입차 시간, 누적 주차 시간, 차량 상태를 저장할 배열 초기화
        int[] inT = new int[10000];
        int[] sumT = new int[10000];
        int[] isIn = new int[10000];

        // 주어진 주차기록(records)을 처리
        for (String x : records) {
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            String c = x.split(" ")[2];

            if (c.equals("IN")) { // 차량이 입차한 경우
                inT[Integer.parseInt(b)] = getTime(a); // 입차 시간 기록
                isIn[Integer.parseInt(b)] = 1; // 차량 상태를 입차로 설정
            } else { // 차량이 출차한 경우
                // 주차 요금 계산을 위해 주차 시간 누적
                sumT[Integer.parseInt(b)] += (getTime(a) - inT[Integer.parseInt(b)]);
                isIn[Integer.parseInt(b)] = 0; // 차량 상태를 출차로 설정
            }
        }

        // 아직 주차장에 머물러 있는 차량들에 대해 주차 요금 계산
        for (int i = 0; i < 10000; i++) {
            if (isIn[i] == 1) {
                sumT[i] += (23 * 60 + 59) - inT[i]; // 자정 전까지 주차한 것으로 가정
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            if (sumT[i] > 0) {
                // 주차 요금 계산 및 저장
                res.add(fees[1] + Math.max((int) (Math.ceil((double) (sumT[i] - fees[0]) / fees[2])), 0) * fees[3]);
            }
        }

        // ArrayList를 배열로 변환하여 반환
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }
}
