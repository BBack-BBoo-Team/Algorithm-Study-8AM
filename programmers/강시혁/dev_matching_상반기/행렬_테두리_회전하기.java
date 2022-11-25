package programmers.강시혁.dev_matching_상반기;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.System.out;

/**
 * Level1
 * 행렬 테두리 회전하기
 */
public class 행렬_테두리_회전하기 {

    public static void main(String[] args) {
        행렬_테두리_회전하기 test = new 행렬_테두리_회전하기();
        int[] result = test.solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});
        Arrays.stream(result).forEach(out::println);
    }
    
    public int[] solution(int rows, int columns, int[][] queries) {

        int[] answer = new int[queries.length];
        int[][] numberBoard = getNumberBoard(rows, columns);

        for (int i = 0; i < queries.length; i++) {

            int left_row = queries[i][0];
            int left_column = queries[i][1];
            int right_row = queries[i][2];
            int right_column = queries[i][3];
            ArrayList<Integer> checkNum = new ArrayList();
            int currRow = left_row;
            int currColumn = left_column;
            int currPoint = numberBoard[currRow][currColumn];
            int lastPoint = numberBoard[left_row+1][left_column];
            while(!checkNum.contains(lastPoint)) {

                if(currRow == left_row) {
                    if(currColumn == right_column) {
                        currRow++;
                    } else {
                        currColumn++;
                    }
                } else if(currRow == right_row) {
                    if(currColumn == left_column) {
                        currRow--;
                    } else {
                        currColumn--;
                    }
                } else {
                    if(currColumn == right_column) {
                        currRow++;
                    } else {
                        currRow--;
                    }
                }

                int nextPoint = numberBoard[currRow][currColumn];
                numberBoard[currRow][currColumn] = currPoint;
                checkNum.add(currPoint);
                currPoint = nextPoint;
            }
            answer[i] = checkNum.stream().mapToInt(m->m).min().getAsInt();
        }

        return answer;
    }

    private int[][] getNumberBoard(int rows, int columns) {
        int[][] board = new int[rows+1][columns+1];
        int num = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                board[i][j] = num;
                num++;
            }
        }
        return board;
    }
}
