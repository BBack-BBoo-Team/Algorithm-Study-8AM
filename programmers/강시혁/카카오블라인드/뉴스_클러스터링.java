package programmers.강시혁.카카오블라인드;

import java.util.HashMap;

import static java.lang.Math.min;
import static java.lang.Math.max;

public class 뉴스_클러스터링 {

    public static void main(String[] args) {
        뉴스_클러스터링 test = new 뉴스_클러스터링();
        String str1 = "FRANCE";
        String str2 = "french";
        int result = test.solution(str1, str2);
        System.out.println(result);

        str1 = "aa1+aa2";
        str2 = "&%^*%^*12";
        result = test.solution(str1, str2);
        System.out.println(result);

        str1 = "E=M*C^2";
        str2 = "e=m*c^2";
        result = test.solution(str1, str2);
        System.out.println(result);
    }

    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        HashMap<String, Integer> str1Map = new HashMap<>();
        HashMap<String,Integer> str2Map = new HashMap<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            char current = str1.charAt(i);
            char next = str1.charAt(i+1);
            if (current < 65 || current > 90 || next < 65 || next > 90) continue;


            String newStr = str1.substring(i,i+2);
            str1Map.put(newStr, str1Map.getOrDefault(newStr, 0)+1);
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char current = str2.charAt(i);
            char next = str2.charAt(i+1);
            if (current < 65 || current > 90 || next < 65 || next > 90) continue;

            String newStr = str2.substring(i,i+2);
            str2Map.put(newStr, str2Map.getOrDefault(newStr, 0)+1);
        }

        double interSet =0 , sumSet = 0;

        for (String v : str1Map.keySet()) {
            if(str2Map.containsKey(v)) {
                interSet += min(str1Map.get(v), str2Map.get(v));
                sumSet += max(str1Map.get(v), str2Map.get(v));
                str2Map.remove(v);
            } else {
                sumSet += str1Map.get(v);
            }
        }

        if(!str2Map.isEmpty()) {
            for (String v : str2Map.keySet()) {
                sumSet += str2Map.get(v);
            }
        }

        double oper = interSet / sumSet;

        if(interSet == 0 || sumSet == 0) {
            oper = 1;
        }

        int answer = (int) (65536 * oper);

        return answer;
    }
}
