public class LongestValidParentheses {

    public static boolean checkParenthesis(String s){
        int tmp = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') tmp++;
            else{
                tmp--;
                if(tmp < 0) return false;
            }
        }
        return tmp == 0;
    }

    public static int longestValidParentheses(String s){
        if(s == null || s.isEmpty() || s.length() < 2) return 0;

        int max_len = 2;

        while(max_len <= s.length()) {
            boolean found_one = false;

            int i = 0;
            while(i < s.length()){
                if(i + max_len > s.length()) break;
                if(checkParenthesis(s.substring(i, i + max_len))){
                    found_one = true;
                    break;
                }
                i++;
            }

            if(!found_one) return max_len - 2;
            max_len += 2;
        }
        return max_len - 2;
    }

    public static void main(String[] args){
        System.out.println("Hello".substring(3, 5));
        System.out.println(longestValidParentheses("(()(()(()"));
    }
}
