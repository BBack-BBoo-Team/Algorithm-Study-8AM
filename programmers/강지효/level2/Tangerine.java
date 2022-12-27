package programmers.강지효.level2;

import java.util.*;

public class Tangerine {
    public static void main(String[] args) {
        int k = 2;
        int[] tangerine = new int[]{1, 1, 1, 1, 2, 2, 2, 3};
        int answer = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i : tangerine){
            if(hm.containsKey(i)){
                hm.put(i,hm.get(i)+1);
            }else{
                hm.put(i,1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(hm.values());
        Collections.sort(list, Collections.reverseOrder());
        for (int i = 0 ; i < list.size();i++){
            if(k <= 0) break;
            else{
                k -=  list.get(i);
                answer++;
            }
        }

            System.out.println(answer);
        //시간초과
/*        // 배열 중복제거
        HashSet<Integer> hs = new HashSet<>();
        for(int i : tangerine){
            hs.add(i);
        }

        // 각 귤의 크기 갯수확인
        ArrayList<Integer> num = new ArrayList<>();
        List<Integer> list = Arrays.stream(tangerine)
                .boxed()
                .collect(Collectors.toList());
        Iterator iter = hs.iterator();
        while(iter.hasNext()){
            num.add(Collections.frequency(list, iter.next()));
        }

        //내림차순 정렬
        Collections.sort(num, Collections.reverseOrder());

        for (int i = 0 ; i < num.size();i++){
            if(k <= 0) break;
            else{
                k -=  num.get(i);
                answer++;
            }
        }

        System.out.println(answer);*/
    }
}
