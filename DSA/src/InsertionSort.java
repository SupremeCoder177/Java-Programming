public class InsertionSort {

    public static void insertionSort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            int temp = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] > temp){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
    }

    public static void main(String[] args){
        int[] nums = {10, 4, 3, 7, 2, 1, 6, 5, 9, 0, 8};

        insertionSort(nums);

        for(int i : nums) System.out.print(i + " ");
        System.out.println();
    }
}
