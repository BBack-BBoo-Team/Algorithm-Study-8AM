package programmers.강시혁.level2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {

    public static void main(String[] args) {
        프린터 test = new 프린터();
        int result = test.solution(new int[]{2, 1, 3, 2}, 2);
        System.out.println(result); // 1

        int result2 = test.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
        System.out.println(result2); // 5
    }

    // main method
    public int solution(int[] priorities, int location) {
        int count = 0;
        Queue<Integer> printerQueue = arrToQueue(priorities);
        Queue<Integer> indexQueue = indexToQueue(priorities);

        while (!printerQueue.isEmpty()) {
            int maxPriority = getMaxPriority(printerQueue);
            if (isMaxPriority(printerQueue.peek(), maxPriority)) {
                if (indexQueue.peek() == location) {
                    count++;
                    break;
                }
                printerQueue.poll();
                indexQueue.poll();
                count++;
            } else {
                printerQueue.add(printerQueue.poll());
                indexQueue.add(indexQueue.poll());
            }
        }
        return count;
    }

    private Queue<Integer> indexToQueue(int[] priorities) {
        Queue<Integer> indexQueue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            indexQueue.add(i);
        }
        return indexQueue;
    }

    private boolean isMaxPriority(int currentPriority, int maxPriority) {
        return currentPriority == maxPriority;
    }

    private int getMaxPriority(Queue<Integer> queue) {
        return queue.stream().mapToInt(a -> a).max().getAsInt();
    }

    private Queue<Integer> arrToQueue(int[] priorities) {
        Queue<Integer> queue = new LinkedList<>();
        for (Integer priority : priorities) {
            queue.add(priority);
        }
        return queue;
    }
}
