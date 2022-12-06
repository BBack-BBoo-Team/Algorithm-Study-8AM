public class 콜라문제 {
    public static void main(String[] args) {
        System.out.println(solution(3,1,20));
    }

    public static int solution(int a, int b, int n) {

        int n1 = n;
        int count = 0;

        while(n1 >= a) {
           int temp = (n1/a) * b;
            count += (n1/a) * b;
            n1 -= (n1/a) * a;
            n1 += temp;
        }


        return count;
    }

}
