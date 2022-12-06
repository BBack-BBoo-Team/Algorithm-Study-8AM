package programmers.강시혁.level2;

import java.util.Arrays;

public class H_INDEX {

    public static void main(String[] args) {
        H_INDEX test = new H_INDEX();
        int result = test.solution2(new int[]{3, 0, 6, 1, 5});// 3
        System.out.println(result);

        result = test.solution2(new int[]{6, 5, 5, 5, 3, 2, 1, 0});// 4
        System.out.println(result);
    }

    // 통과는 했으나 Stream 사용으로 인해서 느리다.
    public int solution(int[] citations) {
        int h = citations.length;
        for (; h >= 0; h--) {
            int finalH = h;
            long count = Arrays.stream(citations).filter(a -> a >= finalH).count();
            if (count >= h) {
                return h;
            }
        }
        return 0;
    }
    
    public int solution2(int[] citations) {
        Arrays.sort(citations);
        int max = 0;
        for(int i = citations.length-1; i > -1; i--) {
            int min = Math.min(citations[i], citations.length-i);

            if(max < min) max = min;
        }
        return max;
    }

}
