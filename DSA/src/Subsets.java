import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> output = new ArrayList<>();

        int n = nums.length;
        int takings = 1;
        output.add(new ArrayList<>(){});
        Set<List<Integer>> uniques = new HashSet<>();
        
        while(takings <= n){

            takings++;
        }

        return output;
    }

    public static void main(String[] args){

    }

}
