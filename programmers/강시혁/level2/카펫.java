package programmers.강시혁.level2;

import java.util.Arrays;

import static java.lang.System.out;

public class 카펫 {

    public static void main(String[] args) {

        카펫 test = new 카펫();
        int[] result = test.solution(10, 2);
        Arrays.stream(result).forEach(out::println); // 4,3

        result = test.solution(8, 1);
        Arrays.stream(result).forEach(out::println); // 3,3

        result = test.solution(24, 24);
        Arrays.stream(result).forEach(out::println); // 8,6
    }
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        return answer;
    }
}
