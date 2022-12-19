package programmers.강시혁.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 모의고사 {

    public static void main(String[] args) {
        모의고사 test = new 모의고사();
        int[] result = test.solution(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(result));
    }

    final int[] student1 = new int[]{1, 2, 3, 4, 5};
    final int[] student2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    final int[] student3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int amount = answers.length;
        int[] scoreArr = new int[3];

        // 1. 학생들의 score 체크
        for (int i = 0; i < amount; i++) {
            if (answers[i] == student1[i % student1.length]) scoreArr[0]++;
            if (answers[i] == student2[i % student2.length]) scoreArr[1]++;
            if (answers[i] == student3[i % student3.length]) scoreArr[2]++;
        }

        // 2. score 중 최대 점수 출력
        int maxScore = getMaxScore(scoreArr);

        // 3. List 에 최대 점수인 학생 저장
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (maxScore == scoreArr[i]) {
                answerList.add(i + 1);
            }
        }
        return answerList.stream().mapToInt(a -> a).toArray();
    }

    private int getMaxScore(int[] score) {
        return Math.max(score[0]
                , Math.max(score[1], score[2]));
    }
}
