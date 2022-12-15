public class 조이스틱 {
    public static void main(String[] args) {

        int value = solution("JAZ");
        System.out.println(value);
    }

    static public int solution(String name) {

        int naturalOrderAnswer = 0;
        int reverseOrderAnswer = 0;

        for(int i = 0; i < name.length(); i++) {
            if(name.charAt(i) <= 'N') {
                naturalOrderAnswer += name.charAt(i) - 'A';
            } else {
                naturalOrderAnswer += (name.charAt(i) - 'Z') * (-1) + 1;
            }
            naturalOrderAnswer++;
        }

        int reverse = 0;
        for(int i = 0; i < name.length(); i++) {
            if(name.charAt(reverse) <= 'N') {
                reverseOrderAnswer += name.charAt(reverse) - 'A';
            } else {
                reverseOrderAnswer += (name.charAt(reverse) - 'Z') * (-1) + 1;
            }
            if(i == 0) { reverse = name.length() - 1; }
            else { reverse -= 1; }
            reverseOrderAnswer++;
        }


        return Math.min(naturalOrderAnswer, reverseOrderAnswer);
    }
}
