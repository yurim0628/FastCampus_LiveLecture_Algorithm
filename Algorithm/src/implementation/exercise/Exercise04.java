package implementation.exercise;

/* 프로그래머스 Lv.1 - 키패드 누르기 */
public class Exercise04 {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10; // '*' 키패드를 나타내는 숫자
        int right = 11; // '#' 키패드를 나타내는 숫자

        // 각 키패드 간 거리를 나타내는 배열
        int[][] dist = {
                {0, 0, 3, 0, 0, 2, 0, 0, 1, 0}, // 0부터 9까지의 숫자와 '*'(10), '#'(11)까지의 거리
                {4, 0, 1, 0, 0, 2, 0, 0, 3, 0},
                {3, 0, 0, 0, 0, 1, 0, 0, 2, 0},
                {4, 0, 1, 0, 0, 2, 0, 0, 3, 0},
                {3, 0, 2, 0, 0, 1, 0, 0, 2, 0},
                {2, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                {3, 0, 2, 0, 0, 1, 0, 0, 2, 0},
                {2, 0, 3, 0, 0, 2, 0, 0, 1, 0},
                {1, 0, 2, 0, 0, 1, 0, 0, 0, 0},
                {2, 0, 3, 0, 0, 2, 0, 0, 1, 0},
                {1, 0, 4, 0, 0, 3, 0, 0, 2, 0}, // '*' (10) 키패드까지의 거리
                {1, 0, 4, 0, 0, 3, 0, 0, 2, 0}  // '#' (11) 키패드까지의 거리
        };

        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];

            // 1, 4, 7인 경우 왼손으로 누르기
            if (n == 1 || n == 4 || n == 7) {
                left = n;
                sb.append("L"); // 왼쪽 손가락으로 누른 경우
            }
            // 3, 6, 9인 경우 오른손으로 누르기
            else if (n == 3 || n == 6 || n == 9) {
                right = n;
                sb.append("R"); // 오른쪽 손가락으로 누른 경우
            } else {
                // 2, 5, 8, 0인 경우 가장 가까운 손가락으로 누르기
                if (dist[left][n] < dist[right][n]) {
                    left = n;
                    sb.append('L'); // 왼쪽 손가락이 더 가까운 경우
                } else if (dist[left][n] > dist[right][n]) {
                    right = n;
                    sb.append('R'); // 오른쪽 손가락이 더 가까운 경우
                } else if (hand.equals("left")) {
                    left = n;
                    sb.append('L'); // 거리가 같을 때, 왼손잡이 설정인 경우
                } else {
                    right = n;
                    sb.append('R'); // 거리가 같을 때, 오른손잡이 설정인 경우
                }
            }
        }

        return sb.toString(); // 결과 문자열 반환
    }
}