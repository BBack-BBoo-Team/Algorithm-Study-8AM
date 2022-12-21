package programmers.강시혁.level2;

import java.util.Arrays;
import java.util.HashMap;

public class 귤_고르기 {
    public static void main(String[] args) {
        귤_고르기 test = new 귤_고르기();
        int[] tangerine = {1,3,2,5,4,5,2,3};
        int result = test.solution(6, tangerine);
        System.out.println(result); // 3

        tangerine = new int[]{1,3,2,5,4,5,2,3};
        result = test.solution(4, tangerine);
        System.out.println(result); // 2

        tangerine = new int[]{1,1,1,1,2,2,2,3};
        result = test.solution(2, tangerine);
        System.out.println(result); // 1
    }

    /**
     * 데이터의 범위가 1 ~ 10,000,000 임으로 완전탐색 X,
     * Greedy 알고리즘 필요
     * 중복되는 개수가 적은 요소를 제외하면, 서로 다른 종류의 수가 최솟값으로 구할 수 있음.
     * 반대로하면, 중복되는 개수가 많은 크기의 귤을 고르면 됨.
     */
    public int solution(int k, int[] tangerine) {

        // 1. 동일한 크기의 귤 개수 체크
        HashMap<Integer, Integer> group = checkCount(tangerine);

        // 2. 정렬을 위해 배열에 개수 정보 저장
        int[][] arr = new int[group.size()][2];
        int index = 0;
        for (Integer val : group.keySet()) {
            arr[index][0] = val;
            arr[index][1] = group.get(val);
            index++;
        }

        // 3. 개수를 기준으로 내림차순 정렬
        sortArr(arr);

        // 4. 귤의 개수만큼 K를 감소시키면서 count
        int answer = 0;
        int currCount =0;
        index = 0;
        while(k>0) {
            currCount = arr[index][1];
            k -= currCount;
            answer++;
            index++;
        }

        return answer;
    }

    private void sortArr(int[][] arr) {
        Arrays.sort(arr,(o1, o2) -> {
            return o2[1]-o1[1];
        });
    }

    private HashMap<Integer, Integer> checkCount(int[] tangerine) {
        HashMap<Integer,Integer> group = new HashMap<>();

        for (int i = 0; i < tangerine.length; i++) {
            group.put(tangerine[i],group.getOrDefault(tangerine[i],0)+1);
        }
        return group;
    }
}
