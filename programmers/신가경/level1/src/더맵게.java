import java.util.PriorityQueue;

public class 더맵게 {
    public static void main(String[] args) {
        int[] temp = {1, 2, 3, 9, 10, 12};
        solution(temp, 7);
    }
    static public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i : scoville) {
            queue.offer(i);
        }

        int count = 0;
        while(true) {

            if(queue.peek() < K && queue.size() == 1) {
                return -1;
            }
            if(queue.peek() >= K) {
                break;
            }
            int a = queue.poll();
            int b = queue.poll();

            int result = a + (b*2);

            queue.offer(result);
            count++;

        }
        System.out.println(count);
        return count;
    }
}
