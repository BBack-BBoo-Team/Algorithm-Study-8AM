package programmers.강지효.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MockTest {
    public static void main(String[] args) {
        int[] answers = new int[]{1,3,2,4,2};


        //찍기번호 que에 넣기
        int[] A = new int[]{1, 2, 3, 4, 5};
        int[] B = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] C = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        Queue<Integer> queA = new LinkedList<>();
        Queue<Integer> queB = new LinkedList<>();
        Queue<Integer> queC = new LinkedList<>();
        for(int a : A){
            queA.add(a);
        }
        for(int b : B){
            queB.add(b);
        }
        for(int c : C){
            queC.add(c);
        }

        //정답비교
        int cntA = 0;
        int cntB = 0;
        int cntC = 0;
        for(int i : answers){
            if(queA.peek() == i) cntA++;
            if(queB.peek() == i) cntB++;
            if(queC.peek() == i) cntC++;
            queA.add(queA.poll());
            queB.add(queB.poll());
            queC.add(queC.poll());
        }

        //MAX구하기
        int max = Math.max(Math.max(cntA, cntB),cntC);
        ArrayList<Integer> result = new ArrayList<>();
        if(cntA == max){
            result.add(1);
        }
        if(cntB == max){
            result.add(2);
        }
        if(cntC == max){
            result.add(3);
        }

        int[] answer = new int[result.size()];
        for(int i=0;i <result.size();i++){
            answer[i] = result.get(i);
        }
        System.out.println(answer);
    }
}
