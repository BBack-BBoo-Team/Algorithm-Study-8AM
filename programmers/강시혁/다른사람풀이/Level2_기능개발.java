package programmers.강시혁.다른사람풀이;

import java.util.Arrays;

public class Level2_기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfEnd = new int[100];
        int day = -1;
        for (int i = 0; i < progresses.length; i++) {
            while (progresses[i] + (day * speeds[i]) < 100) {
                day++;
            }
            dayOfEnd[day]++;
        }
        return Arrays.stream(dayOfEnd).filter(i -> i != 0).toArray();
    }
}
