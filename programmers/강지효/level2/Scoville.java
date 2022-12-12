package programmers.강지효.level2;

import java.util.PriorityQueue;

public class Scoville {
    public static void main(String[] args) {
        int[] scoville = new int[]{0,7};
        int K = 7;

        int answer = 0;
        boolean success = false;

        int cnt = 0;
        PriorityQueue<Integer> priorityQue = new PriorityQueue<>();
        for(int i : scoville){
            priorityQue.add(i);
        }
        int newFood = 0;
        while (!priorityQue.isEmpty()){
            if(priorityQue.peek() >= K){
                priorityQue.poll();
                success = true;
            }else if(priorityQue.size() >= 2){
                newFood = priorityQue.poll() + (priorityQue.poll()*2);
                priorityQue.add(newFood);
                cnt++;
            }else{
                priorityQue.poll();
                success = false;
            }
        }
        if(success == true){
            answer = cnt;
        }else{
            answer = -1;
        }
        System.out.println(answer);
    }
}
