public class QuickSort {

    public static void quickSort(int[] nums, int start, int end){
        if(end <= start) return;

        int piv_index = partition(nums, start, end);
        quickSort(nums, start, piv_index - 1);
        quickSort(nums, piv_index + 1, end);
    }

    public static int partition(int[] nums, int start, int end){
        int pivot = nums[end];
        int i = start - 1;

        for(int j = start; j <= end - 1; j++){
            if(nums[j] < pivot){
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        i++;

        int temp = nums[i];
        nums[i] = nums[end];
        nums[end] = temp;

        return i;
    }


    public static void main(String[] args){
        int[] nums = {9, 3, 5, 7, 1, 2, 8, 0};
        quickSort(nums, 0, nums.length - 1);
        for(int i : nums) System.out.print(i + " ");
        System.out.println();
    }
}
