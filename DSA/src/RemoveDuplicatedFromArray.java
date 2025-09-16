import java.util.ArrayList;

public class RemoveDuplicatedFromArray {

    public static int removeDuplicates(int[] nums){
        if(nums == null || nums.length == 0) return 0;

        ArrayList<Integer> elements = new ArrayList<>();
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(!elements.contains(nums[i])){
                elements.add(nums[i]);
                nums[index] = nums[i];
                index++;
            }
        }
        return elements.size();
    }

    public static void main(String[] args){
        int[] nums = {0, 0, 0, 1, 1, 2, 3, 3, 5, 6, 6, 8, 9, 9};
        int count = removeDuplicates(nums);
        System.out.println(count);
        for(int i : nums) System.out.print(i + " ");
    }
}
