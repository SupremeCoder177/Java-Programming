public class CountingSort {

    public static void countSort(int[] nums){
        int max = 0;
        for(int i : nums) max = Math.max(i, max);

        int[] temp = new int[max + 1];

        for(int i : nums) temp[i]++;

        int j = 0;
        for(int i = 0; i < temp.length; i++){
            for(int k = 0; k < temp[i]; k++){
                nums[j] = i;
                j++;
            }
        }
    }

    public static void allCountSort(int[] nums){
        int min = nums[0];
        int max = nums[0];

        for(int val : nums){
            if(val < min) min = val;
            if(val > max) max = val;
        }

        int[] count = new int[(max - min) + 1];

        for(int val : nums){
            count[val + Math.abs(min)]++;
        }

        int index = 0;
        int val = min;
        for(int freq : count){
            for(int i = 0; i < freq; i++){
                nums[index] = val;
                index++;
            }
            val++;
        }
    }

    public static void main(String[] args) {

        int[] nums = {2, 1, 0, 3, 2, 3, 1, 0, 0};
        int[] nums2 = {-100, -34, -122, 0, 32, 101, -45, 2, 0, 1};

        countSort(nums);
        allCountSort(nums2);
        for(int i : nums2) System.out.print(i + " ");
        System.out.println();
    }
}
