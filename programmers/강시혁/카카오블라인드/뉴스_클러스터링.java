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
        str2 = "AAAA12";
        result = test.solution(str1, str2);
        System.out.println(result);

        str1 = "E=M*C^2";
        str2 = "e=m*c^2";
        result = test.solution(str1, str2);
        System.out.println(result);
    }

    /**
     * 반례 point : 공집합을 어떻게 처리하는가
     */
    public int solution(String str1, String str2) {

        // 1. 문자 모두 대문자로 변환
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        // 2. 각 문자열을 두 글자씩 분리 후 중복 체크
        HashMap<String, Integer> str1Map = new HashMap<>();
        HashMap<String, Integer> str2Map = new HashMap<>();
        subStringAndSetCount(str1, str1Map);
        subStringAndSetCount(str2, str2Map);

        // 3. 교집합, 합집합 수 체크
        double interSet = 0, sumSet = 0, result = 0;

        for (String str : str1Map.keySet()) {

            if(str2Map.containsKey(str)) {
                interSet += min(str1Map.get(str), str2Map.get(str));
                sumSet += max(str1Map.get(str), str2Map.get(str));
                str2Map.remove(str);
            } else {
                sumSet += str1Map.get(str);
            }
        }

        for (String str : str2Map.keySet()) sumSet += str2Map.get(str);

        // 공집합일 경우(합집합도 없는 경우)는 유사도 1 * 65536 반환
        if(sumSet == 0) {
            return 65536;
        }
        
        result = interSet / sumSet;
        return (int) (65536 * result);
    }

    private void subStringAndSetCount(String str, HashMap<String, Integer> map) {
        for (int i = 0; i < str.length()-1; i++) {
            char currChar = str.charAt(i);
            char nextChar = str.charAt(i+1);
            if (!isAlphabet(currChar) || !isAlphabet(nextChar)) continue;

            String subStr = str.substring(i, i + 2);
            setCount(map, subStr);
        }
    }

    private static void setCount(HashMap<String, Integer> map, String str) {
        map.put(str, map.getOrDefault(str, 0)+1);
    }

    boolean isAlphabet(char ch) {
        return ch >= 65 && ch <= 90;
    }
}
