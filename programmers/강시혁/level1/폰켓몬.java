package programmers.강시혁.level1;

import java.util.Arrays;
import java.util.HashSet;

public class 폰켓몬 {

    public static void main(String[] args) {
        폰켓몬 test = new 폰켓몬();
        int result = test.solution(new int[]{3, 1, 2, 3});// 2
        System.out.println(result);

        result = test.solution(new int[]{3, 3, 3, 2, 2, 4});// 3
        System.out.println(result);

        result = test.solution(new int[]{3, 3, 3, 2, 2, 2});// 2
        System.out.println(result);
    }

    public int solution(int[] nums) {
        int answer = nums.length / 2;
        HashSet<Integer> set = new HashSet();

        Arrays.stream(nums)
                .forEach(a -> set.add(a));

        if(set.size() < answer) {
            answer = set.size();
        }

        return answer;
    }

}
