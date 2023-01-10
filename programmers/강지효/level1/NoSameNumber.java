package programmers.강지효.level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NoSameNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,3,3,0,1,1};


        Queue<Integer> que = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i : arr){
            que.add(i);
        }

        int preNum = que.poll();
        result.add(preNum);
        while (!que.isEmpty()){
            if(que.peek() != preNum){
                preNum = que.peek();
                result.add(que.poll());

            }else{
                que.poll();
            }
        }

        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length ;i++){
            answer[i] = result.get(i);
        }
        System.out.println(answer);

    }
}
