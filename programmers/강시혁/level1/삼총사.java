package programmers.강시혁.level1;

public class 삼총사 {
    public static void main(String[] args) {
        삼총사 test = new 삼총사();
        int[] number = {-2, 3, 0, 2, -5};
        int result = test.solution(number);
        System.out.println(result);

        number = new int[]{-3, -2, -1, 0, 1, 2, 3};
        result = test.solution(number);
        System.out.println(result);

        number = new int[]{-1, 1, -1, 1};
        result = test.solution(number);
        System.out.println(result);
    }

    int answer, sum;
    boolean[] isVisited;

    public int solution(int[] number) {
        answer = 0;
        isVisited = new boolean[number.length];
        dfs(number, 0, 0);
        return answer;
    }

    void dfs(int[] number, int count, int curr) {

        if (count > 2) {
            if (sum == 0) answer++;
            return;
        }

         for (int i = curr; i < number.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                sum += number[i];
                dfs(number, count + 1, i);
                sum -= number[i];
                isVisited[i] = false;
            }
        }
    }
}
