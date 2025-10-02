public class MSDRadixSort {

    public static void recursiveMSDSort(int[] nums, int exp, int start, int end){
        if(exp == 0) return;

        int[] count = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] temp = new int[end - start];

        if (end - start >= 0) System.arraycopy(nums, start, temp, 0, end - start);

        for(int i = start; i < end; i++){
            int index = (nums[i] / exp) % 10;
            count[index]++;
        }

        int[] count_copy = new int[10];
        int[] end_index_copy = new int[10];
        System.arraycopy(count, 0, count_copy, 0, 10);

        for(int i = 1; i < 10; i++) count[i] += count[i - 1];
        System.arraycopy(count, 0, end_index_copy, 0, 10);

        for(int i : temp){
            int index = (i / exp) % 10;
            nums[count[index] - 1 + start] = i;
            count[index]--;
        }

        for(int i = 0; i < 10; i++){
            if(count_copy[i] > 1){
                int newStart = (i == 0) ? start : start + end_index_copy[i - 1];
                recursiveMSDSort(nums, exp / 10, newStart, start + end_index_copy[i]);
            }
        }
    }

    public static void msdRadixSort(int[] nums){
        int max = nums[0];
        for(int i : nums) if(i > max) max = i;

        int exp = 1;
        while(max / exp >= 10){
            exp *= 10;
        }

        recursiveMSDSort(nums, exp, 0, nums.length);
    }

    public static void main(String[] args){
        int[] temp = {1, 2, 9, 1, 100, 299, 10, 1, 0};
        msdRadixSort(temp);

        for(int i : temp) System.out.print(i + " ");
        System.out.println();
    }

}
