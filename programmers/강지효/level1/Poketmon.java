package programmers.강지효.level1;

import java.util.HashSet;

public class Poketmon {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,3};
        int answer = 0;

/*
        1. N/2마리 포켓몬 데리고 갈 수 있다.
        2. 최대한 다양한 종류의 포켓몬을 데리고 가야 한다.
        3. 데리고 갈 수 잇는 포켓몬 종류의 수를 구하여라.
        hint. 최소값은 1 최대값은 n/2
*/
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i : nums){
            hashSet.add(i);
        }
        if(hashSet.size()>=nums.length/2){
            answer = nums.length/2;
        }else{
            answer = hashSet.size();
        }

        System.out.println(answer);
    }
}
