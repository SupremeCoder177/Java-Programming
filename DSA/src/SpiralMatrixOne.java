import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixOne {

    public static List<Integer> spiralOrder(int[][] matrix){
        if(matrix.length == 0 || matrix == null || matrix[0].length == 0) return null;
        if(matrix.length == 1) {
            List<Integer> temp = new ArrayList<>();
            for(int i : matrix[0]){
                temp.add(i);
            }
            return temp;
        }
        if(matrix[0].length == 1){
            List<Integer> temp = new ArrayList<>();
            for (int[] ints : matrix) {
                temp.add(ints[0]);
            }
            return temp;
        }
        List<Integer> output = new ArrayList<>();
        int row = 0, col = 0;
        boolean rowLooped = false, colLooped = false;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        while(output.size() != matrix.length * matrix[0].length){
            visited[row][col] = true;
            output.add(matrix[row][col]);

            if(!colLooped && !rowLooped) {
                col++;
                if (col == matrix[0].length - 1 || visited[row][col]) {
                    colLooped = true;
                    if(visited[row][col]) {
                        col--;
                        row++;
                    }
                }
            }
            else if(colLooped && !rowLooped){
                row++;
                if(row == matrix.length - 1 || visited[row][col]){
                    rowLooped = true;
                    if(visited[row][col]) {
                        row--;
                        col--;
                    }
                }
            }
            else if(colLooped && rowLooped){
                col--;
                if(col == 0 || visited[row][col]){
                    colLooped = false;
                    if(visited[row][col]){
                        col++;
                        row--;
                    }
                }
            }
            else if(!colLooped && rowLooped){
                row--;
                if(visited[row][col]){
                    rowLooped = false;
                    if(visited[row][col]) {
                        row++;
                        col++;
                    }
                }
            }
            System.out.println();
            for(int i = 0; i < visited.length; ++i){
                for(int j = 0; j < visited[0].length; ++j){
                    System.out.print(visited[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        return output;
    }

    public static void main(String[] args){

        List<Integer> output = spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20},{21,22,23,24}});
        for(int i : output){
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
