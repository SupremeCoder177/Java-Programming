public class InsertionSort {

    public static void insertionSort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            int temp = nums[i];
            int j = 0;
            for(; j < i; j++){
                if(nums[j] > nums[i]) {
                    temp = nums[j];
                    nums[i] = nums[j];
                }else break;
            }
            nums[i - j] = temp;
        }
    }

    public static void main(String[] args){
        int[] nums = {10, 4, 3, 7, 2, 1, 6, 5, 9, 0};

        insertionSort(nums);

        for(int i : nums) System.out.print(i + " ");
        System.out.println();
    }
}
