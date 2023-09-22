package dfs_dfs.example;

import java.util.*;

/* Example01. 이진트리 레벨탐색 */
class Example01 {
    public void BFS() {
        // 정수를 저장하는 큐(Q)를 생성하고, 초기 루트 노드 1을 큐에 추가합니다.
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(1);

        int L = 0; // 레벨(L) 초기화

        // 큐가 비어있지 않을 동안 반복
        while (!Q.isEmpty()) {
            int n = Q.size(); // 현재 레벨에 있는 노드 수를 저장합니다.
            System.out.print(L + " : "); // 현재 레벨을 출력합니다.

            // 현재 레벨의 노드들을 반복하며 출력하고, 자식 노드들을 큐에 추가합니다.
            for (int i = 0; i < n; i++) {
                int v = Q.poll(); // 큐에서 노드를 꺼내옵니다.
                System.out.print(v + " "); // 노드 값을 출력합니다.

                // 현재 노드의 자식 노드(v*2와 v*2+1)를 계산하고, 범위 내에 있는 경우 큐에 추가합니다.
                for (int nv : new int[]{v * 2, v * 2 + 1}) {
                    if (nv > 7) continue; // 노드 값이 7을 초과하는 경우 건너뜁니다.
                    Q.offer(nv); // 자식 노드를 큐에 추가합니다.
                }
            }

            L++; // 다음 레벨로 이동
            System.out.println(); // 현재 레벨의 출력을 마치고 줄바꿈합니다.
        }
    }

    public static void main(String[] args) {
        Example01 T = new Example01();
        T.BFS(); // BFS 메서드 호출하여 실행합니다.
    }
}

