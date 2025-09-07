public class RotatedSortedArraySearch {

    public static int search(int[] nums, int target){
        if(nums.length == 0 || (nums.length == 1 && nums[0] != target)) return -1;
        int i = nums.length - 1;
        for(; i >= 0; i--){
            if(nums[i] == target) return i;
            if(i == 0) break;
            if(nums[i - 1] > nums[i]) {
                if(nums[i - 1] == target) return i - 1;
                break;
            }
        }

        int endPointer = i == 0 ? nums.length : i;
        int startPointer = -1;
        int pointer = endPointer / 2;
        int lastPointer = 0;

        while(startPointer <= endPointer){
            if(nums[pointer] != target) {
                if (nums[pointer] > target) {
                    endPointer = pointer + 1;
                } else {
                    startPointer = pointer - 1;
                }
                lastPointer = pointer;
                pointer = ((endPointer - startPointer) / 2) + startPointer;
                if(pointer == lastPointer) return -1;
            }else return pointer;
        }

        return -1;
    }


    public static void main(String[] args){
        int[] nums = {3, 5, 1};
        System.out.println(search(nums, 3));

    }
}
