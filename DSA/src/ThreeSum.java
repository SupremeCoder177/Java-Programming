import java.util.ArrayList;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums){
        if(nums.length < 3 || nums == null) return null;
        List<List<Integer>> output = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(j == i) continue;
                for(int k = 0; k < nums.length; k++){
                    if(k == i || k == j) continue;
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        for(int l = 0; l < temp.size() - 1; l++){
                            for(int m = l; m < temp.size(); m++){
                                if(temp.get(m) < temp.get(l)){
                                    int holder = temp.get(m);
                                    temp.set(m, temp.get(l));
                                    temp.set(l, holder);
                                }
                            }
                        }
                        if(!output.contains(temp)) output.add(temp);
                    }
                }
            }
        }
        return output;
    }

    public static void main(String[] args){
        List<List<Integer>> output = threeSum(new int[]{1, -1, 0, 2, -1, 3, -1});
        for(List<Integer> temp : output){
            for(Integer i : temp){
                System.out.print(i);
            }
            System.out.println();
        }
    }

}
