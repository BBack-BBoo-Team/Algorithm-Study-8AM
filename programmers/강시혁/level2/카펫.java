package programmers.강시혁.level2;

import java.util.Arrays;

import static java.lang.Math.sqrt;
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

    /**
     * 풀이
     * 1. yellow 의 약수 순회
     * 2. (가로 길이+2)*2 + (세로 길이*2)가 brown과 같을 때 출력
     * 3. 카펫의 모서리 끝 지점마다 추가되는 길이가 있기 때문에, 출력할 땐 각 길이에 +2
     */
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int height = 1;
        for (; height <= sqrt(yellow); height++) {
            if (isDivisor(yellow,height)) {
                int width = yellow / height;
                if (!ExpectIsEqualBrown(width, height, brown)) continue;

                answer[0] = width + 2;
                answer[1] = height + 2;
            }
        }
        return answer;
    }

    private boolean isDivisor(int yellow, int height) {
        return yellow % height == 0;
    }

    private boolean ExpectIsEqualBrown(int width, int height, int brown) {
        return (width+2) * 2 + (height * 2) == brown;
    }
}
