import java.util.ArrayList;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board){
        for(int i = 0; i < board.length; ++i){
            ArrayList<Character> temp = new ArrayList<>();
            for(int j = 0; j < board[0].length; j++){
                if(!temp.contains(board[i][j]) && board[i][j] != '.') {temp.add(board[i][j]); continue;}
                if(temp.contains(board[i][j])) return false;
            }
        }

        for(int i = 0; i < board[0].length; ++i){
            ArrayList<Character> temp = new ArrayList<>();
            for(int j = 0; j < board.length; j++){
                if(!temp.contains(board[j][i]) && board[j][i] != '.') {temp.add(board[j][i]); continue;}
                if(temp.contains(board[j][i])) return false;
            }
        }

        for(int block = 0; block < 3; block++) {
            for(int i = 0; i < 3; i++) {
                ArrayList<Character> temp = new ArrayList<>();
                for (int row = 3 * block; row < 3 * (block + 1); row++) {
                    for (int col = 3 * i; col < 3 * (i + 1); col++) {
                        if (!temp.contains(board[row][col]) && board[row][col] != '.') {
                            temp.add(board[row][col]);
                            continue;
                        }
                        if (temp.contains(board[row][col])) return false;
                    }
                }
                temp.clear();
            }
        }

        return true;
    }


    public static void main(String[] args){


    }
}
