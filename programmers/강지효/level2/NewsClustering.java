package programmers.강지효.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.regex.Pattern;

public class NewsClustering {
    public static void main(String[] args) {
        String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";
        int answer = 0;

        //자카드유사도 = 교집합 / 합집합
        //둘다 공집합일 경우 1
        // 원소중복을 허용하는 다중집합 가능
        // 영문만 허용(공백 숫자 특수 문자 등 영문이 아닌 문자 무시) -> 정규표현식 사용

        //정규표현식
        String pattern = "^[a-zA-Z]*$";

        //문자 2개씩 배열에 담기
        ArrayList<String> element1 = new ArrayList<>();
        ArrayList<String> element2 = new ArrayList<>();
        for(int i = 1; i < str1.length() ; i++){
            String el = Character.toString(str1.charAt(i-1)) + Character.toString(str1.charAt(i));
            boolean ftr = Pattern.matches(pattern, el);
            if(ftr){
                element1.add(el.toUpperCase());
            }
        }
        for(int i = 1; i < str2.length() ; i++){
            String el = Character.toString(str2.charAt(i-1)) + Character.toString(str2.charAt(i));
            boolean ftr = Pattern.matches(pattern, el);
            if(ftr){
                element2.add(el.toUpperCase());
            };
        }
        HashSet<String> elementSet = new HashSet<>(element1);
        for(String e : element2){
            elementSet.add(e);
        }

        double union = 0; //합집합 원소 수
        double intersection = 0; //교집합 원소수
        if(elementSet.size() == 0){
            answer = 1*65536;
        }else{
            for(String e : elementSet){
                int eleNum1 =Collections.frequency(element1,e);
                int eleNum2 = Collections.frequency(element2,e);
                int min = Math.min(eleNum1,eleNum2); // 교집합 원소 수
                int max = Math.max(eleNum1,eleNum2); // 합집합 원소수
                intersection += min;
                union += max;
            }
            answer = (int) (intersection/union*65536);
        }



        System.out.println(answer);
    }
}
