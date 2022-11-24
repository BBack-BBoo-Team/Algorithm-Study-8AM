package programmers.강시혁.다른사람풀이;

import java.util.Arrays;

import static java.util.stream.Collectors.*;

public class Level2_위장 {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .collect(reducing(1L, (x, y) -> x * (y+1)))
                .intValue()-1;
    }
}
