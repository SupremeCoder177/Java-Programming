import java.util.ArrayList;
import java.util.List;

public class letterCombination {

    public static List<String> letterCombination(String digits){
        List<String> output = new ArrayList<>();

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);
        nums.add(7);
        nums.add(8);
        nums.add(9);
        String[][] letters = {
                {"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "h", "i"},
                {"j", "k", "l"},
                {"m", "n", "o"},
                {"p", "q", "r", "s"},
                {"t", "u", "v"},
                {"w", "x", "y", "z"}
        };

        for(int i = 0; i < digits.length(); ++i){
            int num = Integer.parseInt(String.valueOf(digits.charAt(i)));
            String[] letters_to_add = letters[nums.indexOf(num)];
            List<String> temp = new ArrayList<>();
            if(!output.isEmpty()) {
                for (String ch : output) {
                    for (String letter : letters_to_add) {
                        temp.add(ch.concat(letter));
                    }
                }
                output.clear();
                for(String str: temp){
                    output.add(str);
                }
            }else{
                for(String letter: letters_to_add){
                    output.add(letter);
                }
            }
        }
        return output;
    }

    public static void main(String[] args){
        List<String> output = letterCombination("23");
        for(String str: output){
            System.out.println(str);
        }
    }

}
