package stack_queue_heap.example;

import java.util.*;

/* Example03. 최대수입스케쥴 */
class Example03 {
    public int solution(int[][] nums) {
        int answer = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> b - a); // 우선순위 큐를 내림차순으로 정렬
        Arrays.sort(nums, (a, b) -> b[1] - a[1]); // 배열을 두 번째 열 기준으로 내림차순 정렬
        int maxd = nums[0][1]; // 최대 날짜 저장
        int j = 0; // 배열 인덱스를 추적하기 위한 변수

        for (int i = maxd; i >= 1; i--) { // 최대 날짜부터 1까지 거꾸로 반복
            for (; j < nums.length; j++) {
                if (nums[j][1] < i) break; // 날짜가 현재 i보다 작으면 반복 중지
                pQ.add(nums[j][0]); // 우선순위 큐에 가격 추가
            }
            if (!pQ.isEmpty()) answer += pQ.poll(); // 우선순위 큐에서 최댓값(가장 비싼 가격)을 빼내어 answer에 더함
        }
        return answer; // 최종적인 합계 반환
    }

    public static void main(String[] args) {
        Example03 T = new Example03();

        System.out.println(T.solution(new int[][]{{50, 2}, {20, 1}, {40, 2}, {60, 3}, {30, 3}, {30, 1}}));
        System.out.println(T.solution(new int[][]{{50, 2}, {40, 2}, {20, 1}, {10, 1}}));
        System.out.println(T.solution(new int[][]{{70, 5}, {60, 1}, {80, 2}, {70, 1}}));
    }
}