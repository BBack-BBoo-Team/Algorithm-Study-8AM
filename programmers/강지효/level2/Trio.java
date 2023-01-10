package programmers.강지효.level2;

public class Trio {
    public static void main(String[] args) {
        int[] number = new int[]{-3, -2, -1, 0, 1, 2, 3};
        int answer = 0;

         for(int i = 0; i < number.length-2 ; i++){
             for(int j = i+1; j < number.length-1 ; j++){
                 for(int k = j+1; k < number.length ; k++){
                     int sum = number[i] + number[j] + number[k];
                     if( sum == 0){
                         answer++;
                     }
                 }
             }
         }

        System.out.println(answer);
    }
}
