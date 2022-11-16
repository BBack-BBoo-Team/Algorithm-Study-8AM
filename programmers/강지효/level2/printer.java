import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int doc = priorities[location];

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

        return answer;
    }
}
