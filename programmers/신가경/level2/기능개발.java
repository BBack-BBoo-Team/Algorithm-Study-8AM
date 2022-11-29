package programmers.신가경.level2;

import java.util.ArrayList;

public class 기능개발 {
    public static void main(String[] args) {

//        solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
//        solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
//        solution(new int[]{99, 99, 99}, new int[]{1, 1, 1});
        solution(new int[]{95, 94}, new int[]{3,3});

    }

    static public ArrayList<Integer> solution(int[] progresses, int[] speeds) {

        //몇번째 인덱스로 이동할 지 결정하기 위한 변수
        int next = 0;
        //정답(갯수) 담을 ArrayList 생성
        ArrayList<Integer> answer = new ArrayList<>();

        //순서대로 개발 소요시간 확인하기
        for(int i = 0; i < progresses.length; i += next) {

            //확인하는 요소가 마지막 인덱스인 경우
            if(i == progresses.length - 1) {
                answer.add(1);
                break;
            }

            //First element and speed
            int maxDays = daysLeft(progresses[i], speeds[i]);

            for(int j = i+1; j < progresses.length; j++) {

                //확인하는 가장 앞 인덱스의 개발 소요기간 보다 짧거나 같은 경우
                if(daysLeft(progresses[j], speeds[j]) <= maxDays) {

                    //확인하는 요소가 마지막 인덱스인 경우
                    if(j == progresses.length - 1) {
                        next = j-i+1;
                        answer.add(next);
                    }
                    //마지막 인덱스가 아닌 경우는 다음 인덱스 확인
                    continue;

                    //확인하는 가장 앞 인덱스의 개발 소요기간 보다 오래걸리는 경우
                } else {
                    next = j-i;
                    answer.add(next);
                    break;
                }
            }

        }

        return answer;
    }

    //소요시간 계산용 메서드
    static private int daysLeft(int progress, int speed) {

        //Math.ceil이 올림이나, 나누는 수를 float 타입으로 바꾸어주어야 올림된 int로 나옴(int type인 경우는 소숫점에서 올림되어서 int로 바꿨을 때는 올림되지 않은 것으로 보임)
        return (int) Math.ceil((100 - progress) / (float) speed);

    }
}
