public class TrappingRainWater {

    public static int trap(int[] nums){
        if(nums.length <= 1) return 0;

        int ptr = 0;
        while(nums[ptr] == 0) ptr++;
        if(ptr == nums.length - 1) return  0;
        int total_water = 0;
        int i = ptr + 1;

        while(i < nums.length){

            if(nums[i] >= nums[ptr]){
                ptr = i;
                continue;
            }
            else {
                boolean hasGreater = false;
                for(int j = i; j < nums.length; j++){
                    if(nums[j] > nums[i]) {
                        hasGreater = true;
                        break;
                    }
                }
                if(hasGreater) total_water += nums[ptr] - nums[i];
                else ptr = i;
            }
            i++;
        }


        return total_water;
    }

    public static void main(String[] args){
        System.out.println(trap(new int[]{5, 4, 1, 2}));
    }

}
