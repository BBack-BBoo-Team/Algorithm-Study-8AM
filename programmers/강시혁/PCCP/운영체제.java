package programmers.강시혁.PCCP;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 운영체제 {

    public static void main(String[] args) {
        운영체제 test = new 운영체제();
        int[][] program = {{2, 0, 10}, {1, 5, 5}, {3, 5, 3}, {3, 12, 2}};
        long[] result = test.solution(program);
        System.out.println(Arrays.toString(result));

        program = new int[][]{{3, 6, 4}, {4, 2, 5}, {1, 0, 5}, {5, 0, 5}};
        result = test.solution(program);
        System.out.println(Arrays.toString(result));
    }

    // 현재시간 이하로 시작하는 프로그램 중, 우선순위가 낮은 것부터 실행
    public long[] solution(int[][] program) {

        int len = program.length;

        // 시작시간 기준 오름차순으로 정렬
        Arrays.sort(program, (o1, o2) -> o1[1] - o2[1]);

        // 프로그램 점수 1~10 점 사이
        long[] answer = new long[11];
        int idx = 0, count = 0, time = 0, sum = 0;

        // 대기 중인 프로그램 중 우선순위가 낮은 것부터 실행되기 때문에, 아래와 같이 정렬
        PriorityQueue<int[]> waiting = new PriorityQueue<>((o1, o2) ->
                o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        // 모든 프로그램이 실행되었다는 것을 알기 위해 count 체크
        while (count < len) {

            // point) 시작시간이 현재 time 이하일 경우 [대기중]으로 옮김
            for (int i = idx; i < len; i++) {
                int[] curr = program[i];
                int st = curr[1];
                if (st > time) break;
                waiting.add(curr);
                idx++; // 중복 방지
            }
            if (!waiting.isEmpty() && sum <= time) {
                // [대기중] 에서 우선순위가 가장 빠른 프로그램을 poll
                int[] curr = waiting.poll();
                int pri = curr[0];
                int st = curr[1];
                int rt = curr[2];

                // 현재시간에서 시작시간을 빼서 대기시간을 구한 후 ans 에 저장
                answer[pri] += time - st;
                sum = time + rt;
                count++;
            }
            time++;
        }
        answer[0] = sum;
        return answer;
    }
}