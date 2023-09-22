package dfs_dfs.example;

import java.util.*;

/* Example04. 중복 순열 */
class Example04 {
    Stack<Integer> pm = new Stack<>(); // 순열을 저장할 스택(pm) 생성

    public void DFS(int L, int n, int m) {
        if (L == m) { // 길이가 m인 순열을 생성한 경우
            for (int x : pm) // 스택에 저장된 순열을 출력
                System.out.print(x + " ");
            System.out.println(); // 줄 바꿈
        } else {
            for (int i = 1; i <= n; i++) {
                pm.push(i); // 스택에 현재 숫자(i)를 추가
                DFS(L + 1, n, m); // 다음 길이(L+1)의 순열을 재귀적으로 생성
                pm.pop(); // 스택에서 마지막에 추가한 숫자 제거 (백트래킹)
            }
        }
    }

    public void solution(int n, int m) {
        DFS(0, n, m); // 초기 호출: 길이 0부터 시작
    }

    public static void main(String[] args) {
        Example04 T = new Example04();
        T.solution(3, 2); // 길이가 2인 순열 생성
    }
}