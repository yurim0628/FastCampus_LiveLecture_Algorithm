package stack_queue_heap.exercise;

/* 리트코드 875번 Koko Eating Bananas */
class Exercise03 {
    // 먹는 속도(k)로 모든 바나나를 먹을 때 걸리는 시간을 계산하는 함수
    public int Count(int k, int[] piles) {
        int cnt = 0;
        for (int x : piles) {
            cnt += Math.ceil((double) x / k); // 각 바나나 더미에서 먹는 시간을 계산하여 누적
        }
        return cnt; // 총 먹는 시간 반환
    }

    // 주어진 시간(h) 내에 모든 바나나를 먹을 수 있는 최소한의 먹는 속도를 계산하는 함수
    public int minEatingSpeed(int[] piles, int h) {
        int answer = 0; // 최소한의 먹는 속도를 저장하는 변수
        int left = 1; // 가능한 최소 먹는 속도의 범위 시작
        int right = 0; // 가능한 최대 먹는 속도의 범위 끝

        // 가장 큰 더미에서 바나나를 먹는 속도를 계산하여 범위 설정
        for (int x : piles) {
            right = Math.max(right, x);
        }

        while (left <= right) { // 이진 탐색 실행
            int mid = (left + right) / 2; // 중간 먹는 속도 계산

            if (Count(mid, piles) <= h) { // 중간 먹는 속도로 모든 바나나를 먹는 데 걸리는 시간이 주어진 시간 이하인 경우
                answer = mid; // 현재 중간 먹는 속도를 정답으로 저장
                right = mid - 1; // 먹는 속도를 더 줄여본다 (더 최적의 속도를 찾기 위해 범위를 왼쪽으로 이동)
            } else {
                left = mid + 1; // 먹는 속도를 늘려본다 (더 최적의 속도를 찾기 위해 범위를 오른쪽으로 이동)
            }
        }

        return answer; // 최소한의 먹는 속도를 반환
    }
}