package programmers.강시혁.level2;

public class 조이스틱 {
    public static void main(String[] args) {
        조이스틱 test = new 조이스틱();
        System.out.println(test.solution2("JEROEN")); // 56
        System.out.println(test.solution2("JAN")); // 23
        System.out.println(test.solution2("AAABBBABA")); // 10
        System.out.println(test.solution2("A")); // 0
        System.out.println(test.solution2("AAAAABBAAAAAAABAAA")); // 16
        System.out.println(test.solution2("BBBBAAAAB")); // 10
    }

    final int A = 65;
    final int Z = 90;

    public int solution(String name) {
        int count = 0;
        int ignoreCount = 0;
        boolean isPastA = false;

        for(int i = 0 ; i < name.length(); i++) {
            int ch = name.charAt(i);

            if(i==1 && ch==65) {
                isPastA = true;
            }

            if(isPastA && ch == 65) {
                --ignoreCount;
            } else {
                isPastA =false;
            }

            if(ch<79) {
                count += ch-A;
            } else {
                count += (Z-ch)+1;
            }
        }

        count += (name.length()-1) + ignoreCount;
        return count;
    }

    int solution2(String name) {
        int answer = 0;
        int length = name.length();

        int index; // 다음 값들을 확인할 때 사용
        int move = length - 1; // 좌우 움직임 수를 체크

        for(int i = 0; i < name.length(); i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            index = i + 1;
            // 연속되는 A 갯수 확인
            while(index < length && name.charAt(index) == 'A'){
                index++;
            }

            // 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
            move = Math.min(move, i * 2 + length - index);
            // 2022년 이전 테스트 케이스만 확인하면 여기까지해도 정답처리가 되기 때문에, 이전 정답들에는 여기까지만 정리되어 있지만,
            // BBBBAAAAAAAB 와 같이, 처음부터 뒷부분을 먼저 입력하는 것이 더 빠른 경우까지 고려하려면 아래의 코드가 필요합니다.
            move = Math.min(move, (length - index) * 2 + i);
        }
        return answer + move;
    }
}
