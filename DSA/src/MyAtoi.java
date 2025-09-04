import java.util.ArrayList;

public class MyAtoi {

    public static int myAtoi(String s) {
        s = s.trim();
        if(s.isEmpty()) return 0;
        ArrayList<String> mapping = new ArrayList<>();
        long result = 0;
        boolean isNegative = s.charAt(0) == '-';

        for(int j = 0; j < s.length(); j++){
            if(j == 0){
                if(s.charAt(j) == '-' || s.charAt(j) == '+') continue;
            }
            if(Character.isDigit(s.charAt(j))){
                mapping.add(j < s.length() - 1 ?  s.substring(j, j + 1) : s.substring(j));
            }else break;
        }

        for(int i = 0; i < mapping.size(); ++i){
            result += (long)(Long.parseLong(mapping.get(i)) * Math.pow(10, mapping.size() - (i + 1)));

            if(result < 0 && !isNegative) return Integer.MAX_VALUE;
        }
        result = isNegative ? -result : result;
        if(result > 0 && isNegative) return Integer.MIN_VALUE;

        if(result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int)result;
    }

    public static void main(String[] args){
        System.out.println(myAtoi("1337c0d3"));
    }

}
