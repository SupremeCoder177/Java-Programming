public class ValidAnagram {

    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;

        int[] frequency = new int[26];
        int aIndexASCII = 'a';
        for(int i = 0; i < s.length(); i++){
            int index1 = s.charAt(i);
            int index2 =  t.charAt(i);
            frequency[index1 - aIndexASCII]++;
            frequency[index2 - aIndexASCII]--;
        }
        for(int i = 0; i < 26; i++){
            if(frequency[i] != 0) return false;
        }
        return true;
    }


    public static void main(String[] args){
        System.out.println(isAnagram("ccca", "aacc"));
    }
}
