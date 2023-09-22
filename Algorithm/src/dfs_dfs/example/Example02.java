package dfs_dfs.example;

import java.util.*;

/* Example02. 최소 점프 */
class Example02 {
    public int solution(int home) {
        Queue<Integer> Q = new LinkedList<>(); // 정수를 저장하는 큐(Q) 생성
        int[] ch = new int[10001]; // 방문 여부를 나타내는 배열(ch) 생성 (1부터 10000까지의 범위)
        Q.offer(0); // 시작 위치를 큐에 추가
        ch[0] = 1; // 시작 위치 방문 표시
        int L = 0; // 점프 횟수(L) 초기화

        // 큐가 비어있지 않을 동안 반복
        while (!Q.isEmpty()) {
            int n = Q.size(); // 현재 점프 횟수(L)에서 가능한 모든 위치의 개수를 저장
            for (int i = 0; i < n; i++) {
                int x = Q.poll(); // 큐에서 위치를 꺼내옵니다.

                // 가능한 다음 위치들을 계산하고, 목표 위치(home)에 도달하면 현재 점프 횟수(L)를 반환합니다.
                for (int nx : new int[]{x - 1, x + 1, x + 5}) {
                    if (nx == home) return L + 1; // 목표 위치에 도달한 경우
                    // 다음 위치가 범위 내에 있고 아직 방문하지 않았다면 큐에 추가하고 방문 표시를 합니다.
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1; // 방문 표시
                        Q.offer(nx); // 다음 위치를 큐에 추가합니다.
                    }
                }
            }
            L++; // 다음 점프 횟수로 이동
        }
        return 0; // 목표 위치에 도달하지 못한 경우 0을 반환합니다.
    }

    public static void main(String[] args) {
        Example02 T = new Example02();

        System.out.println(T.solution(10));
        System.out.println(T.solution(14));
        System.out.println(T.solution(25));
        System.out.println(T.solution(24));
        System.out.println(T.solution(345));
    }
}