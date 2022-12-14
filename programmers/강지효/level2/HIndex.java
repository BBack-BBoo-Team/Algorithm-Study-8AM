package programmers.강지효.level2;

import java.util.Arrays;
import java.util.Collections;

public class HIndex {
    public static void main(String[] args) {
        int[] citations = new int[]{10,10,16,11,15};
        int answer = 0;

        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());

        int idx = 1;

        while(arr[idx-1] >= idx ){
            answer = idx;
            idx++;
            if(idx > citations.length) break;
        }



        System.out.println(answer);
    }
}
