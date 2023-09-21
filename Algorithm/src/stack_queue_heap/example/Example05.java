package stack_queue_heap.example;

/* Example05. 랜선 자르기 */
class Example05 {
    // k로 나눈 몫의 합을 반환하는 Count 함수
    public int Count(int k, int[] nums) {
        int cnt = 0;
        for (int x : nums) {
            cnt += (x / k); // k로 나눈 몫을 누적하여 합산
        }
        return cnt;
    }

    // n개 이상의 원소가 k 이상이 되도록 k 값을 찾는 solution 함수
    public int solution(int[] nums, int n) {
        int answer = 0;
        int left = 1; // 범위 시작
        int right = 0; // 범위 끝

        // 배열에서 최댓값 찾기
        for (int x : nums) {
            right = Math.max(right, x);
        }

        while (left <= right) { // 이진 탐색 실행
            int mid = (left + right) / 2; // 중간값 계산

            if (Count(mid, nums) >= n) { // 중간값(mid)으로 Count 함수 호출하여 n개 이상이면
                answer = mid; // 현재 중간값을 정답으로 저장
                left = mid + 1; // 더 큰 값들을 탐색하기 위해 범위를 오른쪽으로 이동
            } else {
                right = mid - 1; // 중간값(mid)으로 Count 함수 호출하여 n개 미만이면 범위를 왼쪽으로 이동
            }
        }
        return answer; // 최종적으로 찾은 k 값을 반환
    }

    public static void main(String[] args) {
        Example05 T = new Example05();

        System.out.println(T.solution(new int[]{802, 743, 457, 539}, 11));
        System.out.println(T.solution(new int[]{8593, 9617, 9313, 4513, 7505, 5457, 8257, 4689, 2657}, 100));
        System.out.println(T.solution(new int[]{93, 97, 93, 53, 75, 57, 85, 89, 67}, 30));
    }
}