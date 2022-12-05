package programmers.강지효.level2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Printer {
    public static void main(String[] args) {
        int[] priorities = new int[]{1,1,9,1,1,1};
        int location = 0;

        int doc = priorities[location];
        int answer = 0;

        Queue docs = new LinkedList();
        Queue que = new LinkedList();
        PriorityQueue priorityQue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < priorities.length ; i++){
            if(i == location){
                docs.add(true);
            }else{
                docs.add(false);
            }
            que.add(priorities[i]);
            priorityQue.add(priorities[i]);
        }

        while(!que.isEmpty()){
            if(que.peek() == priorityQue.peek()){
                if(docs.peek().equals(true)){
                    answer++;
                    break;
                }
                que.poll();
                priorityQue.poll();
                docs.poll();
                answer++;
            }else{
                que.add(que.poll());
                docs.add(docs.poll());
            }
        }
        System.out.println(answer);

    }
}
