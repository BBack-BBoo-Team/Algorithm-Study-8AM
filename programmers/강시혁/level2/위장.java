package programmers.강시혁.level2;

import java.util.HashMap;

public class 위장 {
    public static void main(String[] args) {

        위장 test = new 위장();
        String[][] clothes = new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int result = test.solution(clothes);
        System.out.println(result); // 5

        clothes = new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        result = test.solution(clothes);
        System.out.println(result); // 3
    }

    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesMap = new HashMap<>();

        for(int i = 0 ; i < clothes.length; i++) {
            clothesMap.put(
                    clothes[i][1],
                    clothesMap.getOrDefault(clothes[i][1],0)+1
            );
        }

        int answer = 1;
        for (String value : clothesMap.keySet()) {
            answer *= clothesMap.get(value)+1;
        }
        return answer-1;
    }
}
