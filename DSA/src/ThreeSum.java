import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> output = new ArrayList<>();
        if(nums.length < 3) return output;

        int firstPt = 0, secondPt = 1, thirdPt = 2;
        while(firstPt < nums.length){
            if(nums[firstPt] + nums[secondPt] + nums[thirdPt] == 0){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(nums[firstPt]);
                temp.add(nums[secondPt]);
                temp.add(nums[thirdPt]);
                output.add(temp);
            }
            firstPt++;
            secondPt++;
            thirdPt++;
            if(thirdPt > nums.length - 1) thirdPt = 0;
            if(secondPt > nums.length - 1) secondPt = 0;

        }

        return output;
    }

    public static void main(String[] args){
        List<List<Integer>> output = threeSum(new int[]{1, -1, 0, 2, -1});
        for(List<Integer> temp : output){
            for(Integer i : temp){
                System.out.print(i);
            }
            System.out.println();
        }
    }

}
