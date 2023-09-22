package dfs_dfs.example;

import java.util.*;

/* Example05. 순열 구하기 */
class Example05 {
    Stack<Integer> pm = new Stack<>(); // 순열을 저장할 스택(pm) 생성

    public void DFS(int L, int n, int m, int[] ch) {
        if (L == m) { // 길이가 m인 순열을 생성한 경우
            for (int x : pm) // 스택에 저장된 순열을 출력
                System.out.print(x + " ");
            System.out.println(); // 줄 바꿈
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) { // 아직 사용되지 않은 숫자인 경우
                    ch[i] = 1; // 해당 숫자를 사용했음을 표시
                    pm.push(i); // 스택에 현재 숫자(i)를 추가
                    DFS(L + 1, n, m, ch); // 다음 길이(L+1)의 순열을 재귀적으로 생성
                    ch[i] = 0; // 백트래킹: 숫자 사용 표시를 해제
                    pm.pop(); // 스택에서 마지막에 추가한 숫자 제거
                }
            }
        }
    }

    public void solution(int n, int m) {
        int[] ch = new int[n + 1]; // 숫자 사용 여부를 나타내는 배열(ch) 생성
        DFS(0, n, m, ch); // 초기 호출: 길이 0부터 시작
    }

    public static void main(String[] args) {
        Example05 T = new Example05();
        T.solution(3, 2); // 길이가 2인 중복 순열 생성
    }
}
