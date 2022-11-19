package programmers.강시혁.level2;

import java.util.Arrays;

import static java.lang.System.*;

public class 기능개발 {

    public static void main(String[] args) {
        기능개발 test = new 기능개발();
        int[] result = test.solution(
                new int[]{93, 30, 55},
                new int[]{1, 30, 5}
        );

        Arrays.stream(result).forEach(out::println);

        result = test.solution(
                new int[]{95, 90, 99, 99, 80, 99},
                new int[]{1, 1, 1, 1, 1, 1}
        );

        Arrays.stream(result).forEach(out::println);
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        return answer;
    }
}
