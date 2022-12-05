package programmers.강시혁.level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class 실패율 {

    // test code
    public static void main(String[] args) {
        실패율 test = new 실패율();

        int[] result = test.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(", ");
        }
        System.out.println(sb);

        result = test.solution(4, new int[]{4, 4, 4, 4, 4});
        sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(", ");
        }
        System.out.println(sb);
    }

    public int[] solution(int N, int[] stages) {
        HashMap<Integer, Integer> map = new HashMap<>();
        setUserCountWithStageInMap(stages, map);

        double numOfPeople = stages.length;
        double[][] stagesWithFailureRate = new double[N][2];

        for (int i = 0; i < N; i++) {
            int currStage = i+1;

            stagesWithFailureRate[i][0] = currStage;

            if (!isContainsStage(map, currStage)) {
                stagesWithFailureRate[i][1] = 0;
            } else {
                double failureRate = map.get(currStage) / numOfPeople * 100;
                stagesWithFailureRate[i][1] = failureRate;
                numOfPeople -= map.get(currStage);
            }
        }

        sortByFailureRate(stagesWithFailureRate);

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int) stagesWithFailureRate[i][0];
        }

        return answer;
    }

    private boolean isContainsStage(HashMap<Integer, Integer> map, int currStage) {
        return map.containsKey(currStage);
    }

    private void sortByFailureRate(double[][] stagesWithFailureRate) {
        Arrays.sort(stagesWithFailureRate, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return (int) (o1[1] == o2[1] ? o1[0] - o2[0] : o2[1] - o1[1]);
            }
        });
    }

    private void setUserCountWithStageInMap(int[] stages, HashMap<Integer, Integer> map) {
        for (int stage : stages) {
            map.put(stage, map.getOrDefault(stage, 0) + 1);
        }
    }
}
