import java.util.ArrayList;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums){
        if(nums.length < 3 || nums == null) return null;
        List<List<Integer>> output = new ArrayList<>();

        int firstPt = 0, secondPt = (int)(nums.length / 2), thirdPt = nums.length - 1;
        boolean incFirst = false;
        boolean loopedTwo = false, loopedThird = false;

        while(firstPt < nums.length){
            if(nums[firstPt] + nums[secondPt] + nums[thirdPt] == 0){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(nums[firstPt]);
                temp.add(nums[secondPt]);
                temp.add(nums[thirdPt]);
                output.add(temp);
            }
            //changing pointer
            if(loopedTwo && loopedThird) incFirst = true;
            if(incFirst) {firstPt++; loopedTwo = false; incFirst = false; loopedThird = false;}
            if(!loopedTwo) secondPt++;
            if(!loopedThird) thirdPt++;

            if(firstPt == secondPt){
                secondPt++;
            }
            if(firstPt == thirdPt){
                thirdPt++;
            }

            //looping around
            if(thirdPt > nums.length - 1) thirdPt = 0; loopedThird = true;
            if(secondPt > nums.length - 1) secondPt = 0; loopedTwo = true;

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
