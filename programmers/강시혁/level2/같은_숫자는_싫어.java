package programmers.강시혁.level2;

import java.util.Arrays;
import java.util.Stack;

public class 같은_숫자는_싫어 {
    public static void main(String[] args) {
        같은_숫자는_싫어 test = new 같은_숫자는_싫어();
        int[] arr = new int[]{1,1,3,3,0,1,1};
        int[] result = test.solution(arr);
        System.out.println(Arrays.toString(result)); // 1,3,0,1

        arr = new int[]{4,4,4,3,3};
        result = test.solution(arr);
        System.out.println(Arrays.toString(result)); // 4,3
    }

    public int[] solution(int []arr) {

        int firstValue = arr[0];
        int past = firstValue;

        Stack<Integer> temp = new Stack<>();
        temp.add(firstValue);

        for (int i = 1; i < arr.length; i++) {
            if(arr[i]==past) continue;
            temp.add(arr[i]);
            past = temp.peek();
        }

        return temp.stream().mapToInt(v->v).toArray();
    }
}
