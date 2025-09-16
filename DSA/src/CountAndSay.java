public class CountAndSay {

    public static String runLengthEncoding(String s){
        return String.valueOf(s.length()) + s.charAt(0);
    }

    public static String runCoundAndSay(String s){
        StringBuilder output = new StringBuilder();
        int last_index = 0;
        char curr = s.charAt(0);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != curr){
                output.append(runLengthEncoding(s.substring(last_index, i)));
                last_index = i;
                curr = s.charAt(i);
            }
            if(i == s.length() - 1){
                output.append(runLengthEncoding(s.substring(last_index, s.length())));
            }
        }
        return output.toString();
    }

    public static String countAndSay(int n){
        String output = "1";
        for(int i = 0; i < n - 1; i++){
            output = runCoundAndSay(output);
        }
        return output;
    }

    public static void main(String[] args){
        System.out.println(countAndSay(4));
    }
}
