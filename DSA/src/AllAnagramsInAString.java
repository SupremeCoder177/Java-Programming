import java.util.ArrayList;
import java.util.List;

public class AllAnagramsInAString {

    public static List<Integer> findAnagrams(String s, String p){
        if(s.length() < p.length()) return new ArrayList<>();
        List<Integer> indices = new ArrayList<>();

        int[] frequency_valids = new int[26];
        for(int i = 0; i < p.length(); i++){
            frequency_valids[(int)(p.charAt(i)) - (int)('a')]++;
        }

        for(int i = 0; i < (s.length() - p.length()) + 1; i++){
            boolean add = true;
            String sub = s.substring(i, i + p.length());
            int[] sub_frequency = new int[26];
            for(int j = 0; j < sub.length(); j++){
                sub_frequency[(int)(sub.charAt(j)) - (int) 'a']++;
            }
            for(int j = 0; j < 26; j++){
                if(frequency_valids[j] != sub_frequency[j]){
                    add = false;
                    break;
                }
            }

            if(add) indices.add(i);
        }
        return indices;
    }

    public static void main(String[] args){
        List<Integer> output = findAnagrams("cbaebabacd", "abc");
        for(int index : output){
            System.out.print(index + " ");
        }
        System.out.println();

    }
}
