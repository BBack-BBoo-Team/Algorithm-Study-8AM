package programmers.강지효.level2;

public class Joystick {
    public static void main(String[] args) {
        String name = "BBBAAABBBB";
        int answer = 0;

//        char[] arr = new char[26];
//        for(int i=0; i<arr.length;i++){
//            arr[i] = (char) (65+i);
//            System.out.println(i + " : " + arr[i]);
//        }
        //위치 카운트
        int cnt = 0;

        int len = name.length();
        int current = 0;
        int min = len-1;

        for(int i =1;i < len ; i++){
            if(name.charAt(i) != 'A') {
                cnt = len - i + (current*2);
                min = Math.min(min,cnt);
                cnt = (len -i) * 2 + current;
                min = Math.min(min,cnt);
                current = i;

            }
        }
        System.out.println(min);


        //알파멧 카운트
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
//        System.out.println(answer);

    }
}
