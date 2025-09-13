import java.util.ArrayList;

public class AliceBobGame {

    public static boolean doesAliceWin(String s){

        int vowel_count = 0;
        ArrayList<Character> vowels = new ArrayList<>();
        ArrayList<Character> string = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for(int i = 0; i < s.length(); i++) {
            if(vowels.contains(s.charAt(i))) vowel_count++;
            string.add(s.charAt(i));
        }

        if(vowel_count < 1) return false;
        if(vowel_count % 2 != 0) return true;

        int aliceRemove = 0;
        int bobRemove = 0;

        while(!string.isEmpty()){

            if(vowel_count % 2 != 0) aliceRemove = vowel_count;
            else{
                aliceRemove = vowel_count > 2 ? 3 : 1;
            }

            if(!alicePlay(string, vowels, aliceRemove, vowel_count)) return false;


            vowel_count -= aliceRemove;

            if(vowel_count % 2 != 0) bobRemove = 0;
            else{
                bobRemove = vowel_count;
            }

            if(!bobPlay(string, vowels, bobRemove, vowel_count)) return true;

            if(string.isEmpty()) return false;
        }

        return true;
    }

    public static boolean alicePlay(ArrayList<Character> string, ArrayList<Character> vowels, int min_vowel, int max_vowel){

        if(min_vowel == max_vowel) {
            string.clear();
            return true;
        }

        int vowel_count = 0;
        int i = 0;
        for(; i < string.size(); i++){
            if(vowels.contains(string.get(i))) vowel_count++;
            if(vowel_count == min_vowel) break;
        }

        if(vowel_count == 0) return false;

        for(; i >= 0; i--){
            string.remove(i);
        }

        return true;
    }

    public static boolean bobPlay(ArrayList<Character> string, ArrayList<Character> vowels, int min_vowel, int max_vowel){
        if(string.isEmpty()) return false;

        if(min_vowel == max_vowel) {
            string.clear();
            return true;
        }

        int vowel_count = 0;
        int i = 0;
        for(; i < string.size(); i++){
            if(vowels.contains(string.get(i))) vowel_count++;
            if(vowel_count == min_vowel) break;
        }
        i--;

        if(i == 0 && vowels.contains(string.get(0)) && min_vowel == 0){
            for(int j = 0; j < string.size(); j++){
                if(!vowels.contains(string.get(j))) {
                    string.remove(j);
                    return true;
                }
            }
            return false;
        }

        i--;
        for(; i >= 0; i--){
            string.remove(i);
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(doesAliceWin("rriitv"));
    }
}
