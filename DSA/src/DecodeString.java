public class DecodeString {

    public static int numDecodings(String s){
        if(s.isEmpty() || s == null) return 0;
        if(s.charAt(0) == '0') return 0;
        int ways = 0;
        

        return ways;
    }

    public static void main(String[] args){

        System.out.println("Number of ways can be decoded : " + numDecodings("12"));
    }
}
