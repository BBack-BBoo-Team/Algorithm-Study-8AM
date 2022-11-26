package programmers.강시혁.dev_matching_상반기;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.out;

/**
 * Level3
 * __다단계 칫솔 판매__
 */
public class 다단계_칫솔_판매 {
    public static void main(String[] args) {
        다단계_칫솔_판매 test = new 다단계_칫솔_판매();

        String[] enroll = {"john","mary","edward","sam","emily","jaimie","tod","young"};
        String[] referral = {"-","-","mary","edward","mary","mary","jaimie","edward"};
        String[] seller = {"young","john","tod","emily","mary"};
        int[] amount = {12,4,2,5,10};

        int[] result = test.solution(enroll, referral, seller, amount);
        Arrays.stream(result).forEach(out::println);
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};
        return answer;
    }
}

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        boolean correct = true;

        for(int i = 0 ; i < skill_trees.length; i++) {
            String skillTree = skill_trees[i].replaceAll("[^"+skill+"]", "");

            for(int j =0; j < skillTree.length(); j++) {
                if(skillTree.charAt(j) != skill.charAt(j)) {
                    correct = false;
                    break;
                }
                correct = true;
            }

            if(correct == true) {
                answer++;
            }
        }
        return answer;
    }
}

class Solution {

    public int solution(int n) {


        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;

        for (int i = 2; i < n; i++) {
            int num = arr[i - 1] + arr[i - 2];
            arr[i] = num % 1000000007;
        }

        return arr[n-1];
    }
}