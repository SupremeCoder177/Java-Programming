public class TrappingRainWater {

    public static int trap(int[] nums){
        if(nums.length <= 1) return 0;

        int ptr = 0;
        while(nums[ptr] == 0) {
            ptr++;
            if (ptr == nums.length - 1) return 0;
        }
        int total_water = 0;
        int i = ptr + 1;


        int last_max_index = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] >= nums[last_max_index]) last_max_index = j;
        }

        while(i <= last_max_index) {

            if (nums[i] >= nums[ptr]){
                ptr = i;
            }else{
                total_water += nums[ptr] - nums[i];
            }
            i++;
        }
        ptr = nums.length - 1;
        while(nums[ptr] == 0) ptr--;
        i = ptr - 1;
        while(i >= last_max_index){

            if(nums[i] >= nums[ptr]){
                ptr = i;
            }else{
                total_water += nums[ptr] - nums[i];
            }
            i--;
        }
        return total_water;
    }

    public static void main(String[] args){
        //System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        //System.out.println(trap(new int[]{1, 0, 2, 3, 2, 1, 3, 2, 1, 2}));
        System.out.println(trap(new int[]{0, 1, 2, 0, 3 ,0, 1, 2, 0, 0, 4, 2, 1, 2, 5, 0, 1, 2, 0, 2}));
    }

}
