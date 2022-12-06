import java.util.Arrays;

public class 카펫 {
    public static void main(String[] args) {
        Solution.solution(8, 1);
    }



}
class Solution {
    static public int[] solution(int brown, int yellow) {


        // 넓이
        int size = brown + yellow;

        // 세로 가로 길이 찾기
        int n = 2;
        int[] answer = new int[2];
        while(n <= Math.sqrt(size)) {

            if(size % n == 0) {
                if(isValid(n, size / n, brown, yellow)) {
                    answer[1] = n;
                    answer[0] = size / n;
                    break;
                } else {
                    n++;
                }
            } else {
                n++;
            }
        }

        System.out.println(Arrays.toString(answer));
    return answer;
    }

    static private boolean isValid(int width, int height, int brown, int yellow) {
        int y = (width - 2) * (height - 2);
        if(y==yellow) {
            return true;
        } else {
            return false;
        }
    }
}