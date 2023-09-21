package stack_queue_heap.example;

import java.util.*;

/* Example04. 이진 탐색 */
class Example04 {
    public int solution(int[] nums, int target) {
        int answer = 0;
        Arrays.sort(nums); // 배열을 오름차순으로 정렬

        int left = 0, right = nums.length; // 왼쪽 포인터(left)와 오른쪽 포인터(right) 초기화

        while (left <= right) { // 왼쪽 포인터가 오른쪽 포인터보다 작거나 같을 동안 반복
            int mid = (left + right) / 2; // 중간 인덱스(mid) 계산

            if (nums[mid] == target) { // 중간 요소가 타겟과 일치하는 경우
                return mid; // 타겟의 인덱스를 반환
            }

            if (nums[mid] > target) { // 중간 요소가 타겟보다 큰 경우
                right = mid - 1; // 오른쪽 포인터를 중간의 왼쪽으로 이동하여 범위를 좁힘
            } else { // 중간 요소가 타겟보다 작은 경우
                left = mid + 1; // 왼쪽 포인터를 중간의 오른쪽으로 이동하여 범위를 좁힘
            }
        }

        return answer; // 타겟을 찾지 못한 경우 -1을 반환 (타겟이 배열에 없을 때)
    }

    public static void main(String[] args) {
        Example04 T = new Example04();

        System.out.println(T.solution(new int[]{2, 5, 7, 8, 10, 15, 20, 24, 25, 30}, 8));
        System.out.println(T.solution(new int[]{-3, 0, 2, 5, 8, 9, 12, 15}, 0));
    }
}