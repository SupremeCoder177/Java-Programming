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

    public static void main(String[] args) {

        int[] nums = {2, 1, 0, 3, 2, 3, 1, 0, 0};

        countSort(nums);
        for(int i : nums) System.out.print(i + " ");
        System.out.println();
    }
}
