public class SpiralMatrixTwo {

    public static int[][] generateMatrix(int n){
        int[][] output = new int[n][n];

        int row = 0;
        int col = 0;
        int count = 1;
        int positive_row_check = n;
        int positive_col_check = n;
        int negative_row_check = 0;
        int negative_col_check = 0;

        boolean row_traversing = false;
        boolean column_traversing = true;
        boolean traversing_positive = true;

        while(count <= n * n){
            output[row][col] = count;

            if(traversing_positive){
                if(column_traversing){
                    col++;
                    if(col >= positive_col_check){
                        col = positive_col_check - 1;
                        column_traversing = false;
                        row_traversing = true;
                        positive_col_check--;
                    }
                }
                if(row_traversing){
                    row++;
                    if(row >= positive_row_check){
                        row = positive_row_check - 1;
                        col--;
                        row_traversing = false;
                        positive_row_check--;
                        traversing_positive = false;
                        column_traversing = true;
                    }
                }
            }
            else{
                if(column_traversing){
                    col--;
                    if(col < negative_col_check){
                        col = negative_col_check;
                        column_traversing = false;
                        row_traversing = true;
                        negative_col_check++;
                    }
                }
                if(row_traversing){
                    row--;
                    if(row <= negative_row_check){
                        row = negative_row_check + 1;
                        col++;
                        row_traversing = false;
                        column_traversing = true;
                        traversing_positive = true;
                        negative_row_check++;
                    }
                }
            }

            count++;
        }
        return output;
    }

    public static void main(String[] args){
        for(int[] v : generateMatrix(5)){
            for(int i : v) System.out.print(i + "   ");
            System.out.println();
        }
    }

}
