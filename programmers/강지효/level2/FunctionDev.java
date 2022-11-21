package programmers.강지효.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FunctionDev {
    public static void main(String[] args) {
        int[] answer = {};

        //입력값
        int[] progresses = new int[]{90, 91, 3, 2};
        int[] speeds = new int[]{4, 3, 1, 1};

        //que 선언
        Queue<Integer> que = new LinkedList();
        ArrayList<Integer> result = new ArrayList<>();


        for(int i = 0; i < progresses.length ; i++){
            double exDays = (double) (100 - progresses[i])/speeds[i]; // 소수점 올림 처리 위해 double 형변환
            int days = (int) Math.ceil(exDays); // 올림 후 다시 형 변환
            que.add(days);
        }
        // 남은 개발 진도 = 100 - 현재 진행도
        // 개발 완료일 = 남은 개발 진도 / 스피드

        int k = que.peek();
        int cnt = 0;

        // 5 10 1 1 20 5 10
        // 90 0 1 1 95 5 10 11

        while(!que.isEmpty()){
            if(que.peek() <= k){
                que.poll();
                cnt++;
            }else{
                result.add(cnt);
                k = que.peek();
                cnt = 0;
            }

            if(que.isEmpty()) {
                result.add(cnt);
            };
        }
        answer = new int[result.size()];
        for(int i = 0; i < result.size();i++){
            answer[i] = result.get(i);
            System.out.println(answer[i]);
        }
    }

}
