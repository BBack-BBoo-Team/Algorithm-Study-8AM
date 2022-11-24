package programmers.신가경.level1;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {


    public static void main(String[] args) {

        int[] test = {3,3,3,2,2,2};
        System.out.println(solution(test));
    }

    static public int solution(int[] nums) {

        int answer = 0;

        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }

        int availableNum = nums.length / 2;

        if(set.size() >= availableNum) {
            answer = availableNum;
        } else {
            answer = set.size();
        }

        return answer;
    }

}
