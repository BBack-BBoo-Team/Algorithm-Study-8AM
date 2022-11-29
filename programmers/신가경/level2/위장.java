package programmers.신가경.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 위장 {
    public static void main(String[] args) {
        String[][] example = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] ex2 = {{"a", "headgear"}, {"b", "headgear"}, {"c", "eyewear"}, {"d", "eyewear"}, {"e", "face"}, {"f", "face"}};
        System.out.println(solution(ex2));
    }


    public static int solution(String[][] clothes) {


        Map<String, ArrayList<String>> map = new HashMap<>();

        for(int i = 0; i < clothes.length; i++) {

            if(map.containsKey(clothes[i][1])) {
                map.get(clothes[i][1]).add(clothes[i][0]);
            } else {
                map.put(clothes[i][1], new ArrayList<>(Arrays.asList(clothes[i][0])));
            }
        }

        int temp = 1;
        for(String key : map.keySet()) {
            temp *= map.get(key).size()+1;
        }
        return temp - 1;


    }
}
