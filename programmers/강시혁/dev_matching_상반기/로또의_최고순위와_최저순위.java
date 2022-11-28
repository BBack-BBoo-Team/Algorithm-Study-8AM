package programmers.강시혁.dev_matching_상반기;

import java.util.HashSet;
import java.util.Set;

/**
 * Level1
 * 로또의 최고 순위와 최저 순위
 */
public class 로또의_최고순위와_최저순위 {

    public static void main(String[] args) {
        로또의_최고순위와_최저순위 test = new 로또의_최고순위와_최저순위();
        int[] solution = test.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
        for (int i : solution) {
            System.out.println(i);
        }
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Set<Integer> lottoSet = new HashSet<>();

        int zeroCount = 0;
        for(int num : lottos) {
            if(num == 0) {
                zeroCount++;
                continue;
            }
            lottoSet.add(num);
        }

        int sameCount = 0;
        for(int winNum : win_nums) {
            if(lottoSet.contains(winNum)) sameCount++;
        }

        int minRight = sameCount;
        int maxRight = sameCount + zeroCount;

        answer[0] = getRanking(maxRight);
        answer[1] = getRanking(minRight);
        return answer;
    }

    public int getRanking(int count) {
        if(count == 6) {
            return 1;
        } else if(count == 5) {
            return 2;
        } else if(count == 4) {
            return 3;
        } else if(count == 3) {
            return 4;
        } else if(count == 2) {
            return 5;
        } else {
            return 6;
        }
    }
}
