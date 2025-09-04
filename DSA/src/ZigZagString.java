public class ZigZagString {

    public static String convert(String s, int numRows){
        char[][] temp = new char[numRows][s.length()];
        int row = 0, col = 0;
        boolean looped = false;

        for(int i = 0; i < s.length(); ++i){
            temp[row][col] = s.charAt(i);
            if(row < numRows - 1 && !looped){
                row++;
            }else{
                looped = true;
                col++;
                if(row > 0) row--;
                if(row == 0) looped = false;
            }
        }

        char[] output = new char[s.length()];
        int count = 0;

        for(int i = 0; i < numRows; ++i){
            for(int j = 0; j < s.length(); ++j){
                if(!(temp[i][j] == '\u0000')){
                    System.out.println(temp[i][j]);
                    output[count] = temp[i][j];
                    count++;
                }
            }
        }

        return String.copyValueOf(output);
    }

    public static void main(String[] args){
        String output = convert("PAYPALISHIRING", 3);
        System.out.println(output);
    }
}

