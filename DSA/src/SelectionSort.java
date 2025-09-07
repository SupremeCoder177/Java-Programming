public class SelectionSort {

    public static void selectionSort(int[] nums){
        for(int i = 0; i < nums.length - 1; i++){
            int min = i;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] < nums[min]) min = j;
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }

    public static void main(String[] args){

        int[] nums = {2, 4, 1, 6, 0, 3, 1, -10, 3, 7, 80, -100};
        selectionSort(nums);

        for(int i : nums) System.out.print(i + " ");
        System.out.println();

    }
}
