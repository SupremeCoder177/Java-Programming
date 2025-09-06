import java.util.ArrayList;

public class DecodeString {

    public static int numDecodings(String s){
        if(s.isEmpty() || s == null) return 0;
        if(s.charAt(0) == '0') return 0;
        int ways = 1;

        ArrayList<Integer> fixed_two_takings_indexs = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0') {
                if(s.charAt(i - 1) == '0') return 0;
                if(i < s.length() - 1 && s.charAt(i + 1) == '0') return 0;
                if(!(Integer.parseInt(String.valueOf(s.charAt(i - 1))) <= 2)) return 0;
                fixed_two_takings_indexs.add(i - 1);
            }
        }
        int num_two_takings = 0;
        ArrayList<Integer> two_slots = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(!fixed_two_takings_indexs.contains(i) && s.charAt(i) != '0' && !fixed_two_takings_indexs.contains(i + 1) && i + 1 < s.length()) {
                if(Integer.parseInt(s.substring(i, i + 2)) <= 26){
                    if(i != 0 && !two_slots.contains(i - 1)){
                        two_slots.add(i);
                    }
                }
            }
        }
        while(num_two_takings < 0) {
            num_two_takings++;
            ways += 1;
        }
        return ways;
    }

    public static void main(String[] args){

        System.out.println("Number of ways can be decoded : " + numDecodings("12398"));
    }
}
