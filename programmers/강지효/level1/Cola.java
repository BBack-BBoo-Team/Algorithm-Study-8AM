package programmers.강지효.level1;

public class Cola {
    public static void main(String[] args) {
        int a = 2; // 최소 반환 개수
        int b = 1; // 반환시 리워드
        int n = 20; // 현재 가지고 있는 빈병
        int answer = 0;
        int cnt = 0;

        while (n >= a){
/*
        1. n을 a로 나눈다
        2 n을 a로 나눈 나머지와 값을 다시 n에 넣는다
        3. 1,2반복
*/
            cnt = n /a;
            answer += cnt*b;
            n = cnt*b + n % a;
        }
        System.out.println(answer);

    }
}
