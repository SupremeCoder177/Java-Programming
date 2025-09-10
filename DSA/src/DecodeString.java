import java.util.ArrayList;

public class DecodeString {

    public static int numDecodings(String s){
        if(s.isEmpty() || s == null) return 0;
        if(s.charAt(0) == '0') return 0;
        int ways = 1;

        ArrayList<Integer> fixed_two_takings_indexs = new ArrayList<>();
        ArrayList<Integer> overlapping_two_takings = new ArrayList<>();
        ArrayList<ArrayList<Integer>> unique_two_takings = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0') {
                if(s.charAt(i - 1) == '0') return 0;
                if(i < s.length() - 1 && s.charAt(i + 1) == '0') return 0;
                if(!(Integer.parseInt(String.valueOf(s.charAt(i - 1))) <= 2)) return 0;
                fixed_two_takings_indexs.add(i - 1);
            }else{
                if(i < s.length() - 1 && s.charAt(i + 1) != '0') {
                    if(i < s.length() - 2 && s.charAt(i + 2) == '0') continue;
                    if (Integer.parseInt(s.substring(i, i + 2)) <= 26 && !fixed_two_takings_indexs.contains(i)) {
                        overlapping_two_takings.add(i);
                    }
                }
            }
        }

        int max_two_takings = 0;
        for(int i : overlapping_two_takings){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(i);
            int even_count = 0;
            int odd_count = 0;
            int j = 0;
            while(j < s.length()){
                if(!overlapping_two_takings.contains(j) || j == i + 1)  j++;
                else{
                    temp.add(j);
                    j += 2;
                    even_count ++;
                }
            }
            j = 1;
            if(j > i){
                temp.add(i);
            }
            while(j < s.length()){
                if(!overlapping_two_takings.contains(j) || j == i + 1) j++;
                else{
                    temp.add(j);
                    j += 2;
                    odd_count ++;
                }
            }
            if(even_count == 0) even_count ++;
            if(odd_count == 0) odd_count ++;
            if(odd_count > max_two_takings) max_two_takings = odd_count;
            if(even_count > max_two_takings) max_two_takings = even_count;
            temp.add(even_count);
            temp.add(odd_count);
            unique_two_takings.add(temp);
        }
        for(ArrayList<Integer> arr : unique_two_takings) {
            for(int i : arr) System.out.print(i + " ");
            System.out.println();
        }
        System.out.println();

        int two_takings = 1;
        while(two_takings * 2 <= s.length()){
            if(two_takings == max_two_takings){
                boolean all_same = false;
                int i = 0;
                while(i < unique_two_takings.size() - 1){
                    ArrayList<Integer> temp = unique_two_takings.get(i);
                    if(temp.get(temp.size() - 2) != max_two_takings && temp.get(temp.size() - 1) != max_two_takings) break;
                    ArrayList<Integer> temp2 = unique_two_takings.get(i + 1);
                    if(temp2.get(temp2.size() - 2) != max_two_takings && temp2.get(temp2.size() - 1) != max_two_takings) break;
                    char compare_with;
                    if(temp.get(temp.size() - 2) == temp.get(temp.size() - 1)){
                        if(temp2.get(temp2.size() - 2) == temp2.get(temp2.size() - 1)){
                            compare_with = 'e';
                        }else{
                            if(temp2.get(temp2.size() - 2) == max_two_takings) compare_with = 'e';
                            else compare_with = 'o';
                        }
                    }else {
                        compare_with = temp.get(temp.size() - 2) == max_two_takings ? 'e' : 'o';
                    }
                    if(compare_with == 'e' && temp2.get(temp2.size() - 2) != max_two_takings) break;
                    if(compare_with == 'o' && temp2.get(temp2.size() - 1) != max_two_takings) break;
                    int start_temp1 = compare_with == 'e' ? 1 : temp.get(temp.size() - 2) + 1;
                    int end_temp1 = compare_with == 'e' ? temp.get(temp.size() - 2) : temp.size() - 2;
                    int start_temp2 = compare_with == 'e' ? 1 : temp2.get(temp2.size() - 2) + 1;
                    int end_temp2 = compare_with == 'e' ? temp2.get(temp2.size() - 2) : temp2.size() - 2;
                    if(end_temp1 - start_temp1 != end_temp2 - start_temp2) break;
                    int j = 0;
                    boolean break_whole = false;
                    while(j <= end_temp1 - start_temp1){
                        if(temp.get(j + start_temp1) != temp2.get(j + start_temp2)){
                            break_whole = true;
                            break;
                        }
                        j++;
                    }
                    if(break_whole) break;

                    i++;
                    if(i == unique_two_takings.size() - 1){
                        all_same = true;
                    }
                }
                if(all_same){
                    ways++;
                    break;
                }
            }

            for(ArrayList<Integer> arr : unique_two_takings){
                if(two_takings * 2 != s.length()) {
                    if (arr.get(arr.size() - 2) >= two_takings || arr.get(arr.size() - 1) >= two_takings) ways++;
                }else{
                    if(arr.get(arr.size() - 2) >= two_takings || arr.get(arr.size() - 1) >= two_takings){
                        ways++;
                        break;
                    }
                }
            }
            two_takings++;
        }
        return ways;
    }

    public static void main(String[] args){

        System.out.println("Number of ways can be decoded : " + numDecodings("226"));
    }
}
