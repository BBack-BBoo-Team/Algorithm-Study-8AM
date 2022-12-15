package programmers.강지효.level2;

public class Carpet {
    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;
        int[] answer = new int[2];

        int a = 1;
        int b = 1;
        int cnt = 1;
        int brownSum = 0;
        if(yellow != 1){
            while (brownSum != brown){
                cnt++;
                if(yellow % cnt == 0){
                    a = yellow/cnt;
                    b = cnt;
                    brownSum = (a*2) + (b*2) + 4;
                }
            }
        }
        if(a >= b){
            answer[0] = a +2;
            answer[1] = b +2;
        }else{
            answer[0] = b +2;
            answer[1] = a +2;
        }


        System.out.println(a+2);
        System.out.println(b+2);
    }
}
