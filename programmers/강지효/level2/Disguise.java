package programmers.강지효.level2;

import java.util.HashMap;

public class Disguise {
    public static void main(String[] args) {
        String[][] clothes = new String[][]{{"yellow","hat"},{"green","hat"},{"black","sunglasses"}};
        int answer = 0;

        // 각 배열은 [의상이름,종류]로 구성
        // 같은 이름의 의상없음
        // 최소 1개의 의상은 착용

        HashMap<String,Integer> hashMap = new HashMap<>();
        for(String[] clothe : clothes ){
            if(!hashMap.containsKey(clothe[1])){
                hashMap.put(clothe[1],1);
            }else{
                hashMap.put(clothe[1],hashMap.get(clothe[1])+1);
            }
        }
        int total = 1;
        for(String key : hashMap.keySet()){
            int value = hashMap.get(key)+1; // 선택하지 않을수 있는 옵션 포함
            total *= value;
        }
        answer = total -1; // 아무것도 선택하지않는 옵션은 포함되어있지 않기때문에 그 경우를 빼기위한 -1

//        if(hashMap.size() > 1){ // size가 3개 이상일 때 단순 곱하기로 해결 안됨 ex) 2, 2, 1 개 일 경우 5(1개씩) 4, 2, 2(2개씩 착용) , 4(3개씩 착용))
//            int total = 1;
//            for(String key : hashMap.keySet()){
//                int value = hashMap.get(key);
//                total *= value;
//            }
//            answer = total + clothes.length;
//        }else{
//            answer = clothes.length;
//        }
        System.out.println(answer);
    }
}
