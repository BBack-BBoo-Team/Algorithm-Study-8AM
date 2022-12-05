package programmers.강시혁.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.out;

public class 기능개발 {

    // 실행 코드
    public static void main(String[] args) {
        기능개발 test = new 기능개발();

        int[] result = test.solution(
                new int[]{93, 30, 55},
                new int[]{1, 30, 5}
        );
        Arrays.stream(result).forEach(out::print);

        out.println();

        result = test.solution(
                new int[]{95, 90, 99, 99, 80, 99},
                new int[]{1, 1, 1, 1, 1, 1}
        );
        Arrays.stream(result).forEach(out::print);
    }

    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> remainingDaysList = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remainingDays = roundUp(
                    getRemainingDays(progresses[i], speeds[i])
            );
            remainingDaysList.add(remainingDays);
        }

        int base = remainingDaysList.peek();
        int count = 0;
        ArrayList<Integer> countOfCompleteTask = new ArrayList<>();

        while (!remainingDaysList.isEmpty()) {

            if (remainingDaysList.peek() <= base) {
                count++;
                if (isLastInList(remainingDaysList.size())) {
                    countOfCompleteTask.add(count);
                }
                remainingDaysList.poll();
            } else {
                countOfCompleteTask.add(count);
                base = remainingDaysList.peek();
                count = 0;
            }
        }

        int[] answer = new int[countOfCompleteTask.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = countOfCompleteTask.get(i);
        }
        return answer;
    }

    private boolean isLastInList(int size) {
        return size == 1;
    }

    private int roundUp(double remainingDays) {
        return (int) Math.ceil(remainingDays);
    }

    private double getRemainingDays(int progress, int speed) {
        return (double) (100-progress) / speed;
    }
}
