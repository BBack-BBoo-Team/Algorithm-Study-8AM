package programmers.강지효.level1;

public class failureRate {
    public static void main(String[] args) {
        int[] stages = new int[]{3,1,1,2,2};
        int N = 4;
        int[] answer = {};
        answer = new int[N];

        double[] failureRate = new double[N+2];
        int[] failureNum = new int[N+2];

        int userNum = stages.length; //유저 수
        for(int i : stages){ // 스테이지 별 멈춰있는 유저 수
            failureNum[i] += 1 ;
        }

        for(int j = 1; j <= N+1; j++){ // 각 스테이지 별 실패율
            failureRate[j] = (double) failureNum[j]/userNum;
            userNum -= failureNum[j];
            System.out.println(failureRate[j]);
            if(userNum == 0) break; // 설정 안해주면 ArithmeticException발생 -> 숫자를 0으로 나누려고할 때 발생하는 에러
        }
        double max;
        for(int j = 1 ; j < N+1 ; j++){
            max = -0.1;
            for(int i = 1; i < N+1 ; i++){
                if(failureRate[i] > max){
                    max = failureRate[i];
                    answer[j-1] = i;
                }
            }
            failureRate[answer[j-1]] = -1;
        }
        for(int i : answer){
            System.out.println(i);
        }



    }
}
