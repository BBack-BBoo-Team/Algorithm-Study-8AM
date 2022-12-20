package programmers.강시혁.level2;

import java.util.*;

import static java.lang.Math.*;

public class 전력망을_둘로_나누기 {

    public static void main(String[] args) {
        전력망을_둘로_나누기 test = new 전력망을_둘로_나누기();
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        int result = test.solution(9, wires);
        System.out.println(result);

        wires = new int[][]{{1, 2}, {2, 3}, {3, 4}};
        result = test.solution(4, wires);
        System.out.println(result);
    }

    ArrayList<Integer> list[];

    public int solution(int n, int[][] wires) {
        int answer = 100;

        list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < wires.length; i++) {
            list[wires[i][0]].add(wires[i][1]);
            list[wires[i][1]].add(wires[i][0]);
        }

        for (int i = 0; i < wires.length; i++) {
            int n1 = bfs(wires[i][0], wires[i][1], n);
            int n2 = bfs(wires[i][1], wires[i][0], n);

            answer = min(answer, abs(n1 - n2));
        }

        return answer;
    }

    int bfs(int v1, int v2, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[n + 1];

        int count = 0;
        queue.add(v1);
        visited[v1] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;

            for (int next : list[cur]) {
                if (!visited[next] && next != v2) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        return count;
    }
}
