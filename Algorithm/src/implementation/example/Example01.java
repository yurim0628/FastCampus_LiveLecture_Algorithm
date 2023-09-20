package implementation.example;

/* Example01. 웅덩이 */
class Example01 {
    // solution 메서드: 웅덩이 개수 계산
    public int solution(int[][] nums){
        // 방향을 나타내는 배열
        int[] dr = {-1, 0, 1, 0}; // 상, 우, 하, 좌
        int[] dc = {0, 1, 0, -1};
        int answer = 0; // 웅덩이 개수를 저장하는 변수
        int n = nums.length; // 배열의 행과 열 길이

        // 모든 좌표에 대한 검사
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                boolean flag = true; // 웅덩이 여부를 판단하기 위한 플래그

                // 상하좌우로 인접한 지점 검사
                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k]; // 현재 위치에서 상하좌우로 이동한 행
                    int nc = c + dc[k]; // 현재 위치에서 상하좌우로 이동한 열

                    // 배열 범위 내에서 현재 위치의 높이보다 낮은 높이인 경우
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && nums[nr][nc] <= nums[r][c]) {
                        flag = false; // 웅덩이가 아님
                        break; // 더 이상 검사하지 않고 종료
                    }
                }

                if (flag) {
                    answer++; // 웅덩이인 경우 answer 증가
                }
            }
        }

        return answer; // 최종 웅덩이 개수 반환
    }

    public static void main(String[] args){
        Example01 T = new Example01();
        System.out.println(T.solution(new int[][]{{10, 20, 50, 30, 20}, {20, 30, 50, 70, 90}, {10, 15, 25, 80, 35}, {25, 35, 40, 55, 80}, {30, 20, 35, 40, 90}}));
        System.out.println(T.solution(new int[][]{{80, 25, 10, 65, 100}, {20, 10, 32, 70, 33}, {45, 10, 88, 9, 90}, {10, 35, 10, 55, 66}, {10, 84, 65, 88, 99}}));
        System.out.println(T.solution(new int[][]{{33, 22, 55, 65, 55}, {55, 88, 99, 12, 19}, {18, 33, 25, 57, 77}, {46, 78, 54, 55, 99}, {33, 25, 47, 85, 17}}));
    }
}