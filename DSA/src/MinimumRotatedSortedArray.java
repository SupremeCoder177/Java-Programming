public class MinimumRotatedSortedArray {

    public static int findMin(int[] nums){
        for(int i = nums.length - 1; i >= 0; i--){
            if(i == 0) return nums[0];
            if(nums[i - 1] > nums[i]) return nums[i];
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums));
    }
}
