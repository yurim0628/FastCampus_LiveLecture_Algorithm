package dfs_dfs.exercise;

/* 프로그래머스 - 체육대회 */
public class Exercise02 {
    int answer = 0; // 결과값을 저장할 변수

    public void DFS(int L, int sum, int[][] ability, int[] ch, int n, int m) {
        if (L == m) { // L이 m과 같아진 경우 (하나의 팀을 완성한 경우)
            answer = Math.max(answer, sum); // 현재 합계(sum)와 이전의 최댓값을 비교하여 더 큰 값을 answer에 저장
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) { // 아직 선택되지 않은 선수인 경우
                    ch[i] = 1; // 해당 선수를 선택했음을 표시
                    DFS(L + 1, sum + ability[i][L], ability, ch, n, m); // 다음 레벨(L+1)로 이동하며 합계(sum)를 업데이트
                    ch[i] = 0; // 백트래킹: 해당 선수 선택 해제
                }
            }
        }
    }

    public int solution(int[][] ability) {
        int n = ability.length; // 선수의 수 (능력치 배열의 행 수)
        int m = ability[0].length; // 팀의 인원 수 (능력치 배열의 열 수)
        int[] ch = new int[n]; // 선수 선택 여부를 나타내는 배열 초기화
        DFS(0, 0, ability, ch, n, m); // 초기 호출: 레벨 0부터 시작, 합계 0부터 시작
        return answer; // 최댓값인 answer 반환
    }
}
