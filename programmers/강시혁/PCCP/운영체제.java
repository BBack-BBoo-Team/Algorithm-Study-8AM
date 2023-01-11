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

    // 현재 시가 이하로 시작하는 프로그램 중, 우선순위가 낮은 것부터 실행
    public long[] solution(int[][] program) {

        int len = program.length;
        Arrays.sort(program, (o1, o2) -> o1[1] - o2[1]);

        PriorityQueue<int[]> waiting = new PriorityQueue<>((o1, o2) ->
                o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        long[] answer = new long[11];
        int idx = 0, count = 0, time = 0, sum = 0;

        while (count < len) {
            for (int i = idx; i < len; i++) {
                int[] curr = program[i];
                int st = curr[1];
                if (st > time) break;
                waiting.add(curr);
                idx++;
            }

            if (!waiting.isEmpty() && sum <= time) {
                int[] curr = waiting.poll();
                int pri = curr[0];
                int st = curr[1];
                int rt = curr[2];

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


