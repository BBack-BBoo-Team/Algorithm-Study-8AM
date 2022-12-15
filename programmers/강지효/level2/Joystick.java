package etc;

public class Joystick {
    public static void main(String[] args) {
        String name = "AAABBBABA";
        int answer = 0;

        //위치(좌우) 카운트
        int cnt = 0;

        int len = name.length();
        int current = 0;
        int min = 0;
        //좌우 이동 최대값 설정
        for(int j =1;j < len ; j++){
            if(name.charAt(j) !='A'){
                min = j;
            }
        }

        // 좌우 이동 비교
        for(int i =1;i < len ; i++){

            if(name.charAt(i) !='A'){
                min = Math.min(min, (current*2) + len -i);
                min = Math.min(min, current + (len -i)*2 );
                current = i;
            }
        }

        answer = min;




        //알파벳(상하) 카운트
        for(int i = 0; i < len;i++){
            char a = 'A';
            cnt = 0;
            while(name.charAt(i) != a){
                cnt++;
                a = (char) (65 + cnt);

            }
            if(cnt > 13){
                answer += 26 - cnt;
            }else{
                answer += cnt;
            }

        }
        System.out.println(answer);

    }
}
