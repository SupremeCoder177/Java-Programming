import java.util.ArrayList;

public class DecodeString {

    public static int numDecodings(String s){
        if(s.isEmpty() || s == null) return 0;
        if(s.charAt(0) == '0') return 0;
        int ways = 1;

        ArrayList<Integer> fixed_two_takings_indexs = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0') {
                fixed_two_takings_indexs.add(i - 1);
            }
        }
        int num_two_takings = 0;
        while((num_two_takings + fixed_two_takings_indexs.size()) * 2 < s.length()){
            ArrayList<Integer> start_two_takings_pointers = new ArrayList<>();
            for(int i = 0; i < s.length(); i++){
                if(i + (num_two_takings * 2) < s.length() && !fixed_two_takings_indexs.contains(i) && s.charAt(i) != '0'){
                    boolean add = true;
                    for(int j = i; j < num_two_takings; j++){
                        if(Integer.parseInt(String.valueOf(s.charAt(i + (j * 2)) + s.charAt(i + (j * 2) + 1))) <= 26) {
                               add = false;
                               break;
                        }
                    }
                    if(add) start_two_takings_pointers.add(i);
                }
            }
            ways += start_two_takings_pointers.size();

            num_two_takings++;
        }

        return ways;
    }

    public static void main(String[] args){

        System.out.println("Number of ways can be decoded : " + numDecodings("226"));
    }
}
