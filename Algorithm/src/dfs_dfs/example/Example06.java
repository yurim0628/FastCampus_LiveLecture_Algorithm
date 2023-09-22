package dfs_dfs.example;

import java.util.*;

/* Example06. 조합 구하기 */
class Example06 {
    Stack<Integer> combi = new Stack<>(); // 조합을 저장할 스택(combi) 생성

    public void DFS(int L, int s, int n, int m) {
        if (L == m) { // 길이가 m인 조합을 생성한 경우
            for (int x : combi) // 스택에 저장된 조합을 출력
                System.out.print(x + " ");
            System.out.println(); // 줄 바꿈
        } else {
            for (int i = s; i <= n; i++) {
                combi.push(i); // 스택에 현재 숫자(i)를 추가
                DFS(L + 1, i + 1, n, m); // 다음 길이(L+1)의 조합을 재귀적으로 생성
                combi.pop(); // 스택에서 마지막에 추가한 숫자 제거 (백트래킹)
            }
        }
    }

    public void solution(int n, int m) {
        DFS(0, 1, n, m); // 초기 호출: 길이 0부터 시작, 시작 숫자는 1부터
    }

    public static void main(String[] args) {
        Example06 T = new Example06();
        T.solution(4, 2); // 1부터 4까지의 숫자 중에서 2개를 조합하여 생성
    }
}
