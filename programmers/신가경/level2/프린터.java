package programmers.신가경.level2;

import java.util.ArrayList;

public class 프린터 {

    public static void main(String[] args) {


        /* test */
        int[] p1 = {2,1,3,2};
        int l1 = 2;

        int[] p2 = {1, 1, 9, 1, 1, 1};
        int l2 = 0;

        System.out.println(solution(p2, l2));

    }


    static public int solution(int[] priorities, int location) {

        ArrayList<Integer> priorityList = new ArrayList<>();
        ArrayList<Integer> indexList = new ArrayList<>();
        int order = 0;
        for(int i = 0; i < priorities.length; i++) {
            priorityList.add(priorities[i]);
            indexList.add(i);
        }

        boolean flag = true;
        boolean innerFlag = true;
        while(flag) {
            for(int i = 1; i < priorityList.size(); i++) {
                if(priorityList.get(i) > priorityList.get(0)) {
                    priorityList.add(priorityList.remove(0));
                    indexList.add(indexList.remove(0));

                    break;
                }
                if(i == priorityList.size() - 1) {
                    innerFlag = false;
                }
            }

            if(!innerFlag) {
                priorityList.remove(0);
                if(indexList.remove(0) == location) {
                    flag = false;
                }
                order++;
                innerFlag = true;
            }
        }


        // for loop으로 [0]과 이후 요소들 크기 비교하기


        // [0] 보다 큰 수가 있는 경우 [0]을 맨 뒤로 보내고 for loop break

        // [0] 보다 큰 수가 없는 경우 [0]과 indexArry[0]도 제거 (혹은 -1로 변경)

        //제거된 indexArray[0]이 location과 일치한다면 while loop도 break하여 나오기

        return order;
    }

}

