package programmers.강시혁.level1;

public class 콜라문제 {
    public static void main(String[] args) {
        콜라문제 test = new 콜라문제();
        System.out.println(test.solution(2, 1, 20)); // 19

        System.out.println(test.solution(3, 1, 20)); // 9
    }

    public int solution(int a, int b, int n) {
        int count = 0;
        int returnCola = n;
        int currentCola = n;
        int restCola = 0;

        while (currentCola >= a) {
            currentCola = returnCola + restCola;
            returnCola = currentCola / a * b;
            restCola = currentCola % a;

            count += returnCola;
        }
        return count;
    }
}
