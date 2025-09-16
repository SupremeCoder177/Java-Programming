import java.util.Random;

// The fastest sorting algorithm out there
public class RadixSort {

    public static void radixSort(int[] nums){
        int max = getMax(nums);

        int n = nums.length;
        int[] count = new int[10];
        int[] output = new int[n];
        int exp = 1;

        while(max / exp > 0){

            for(int i = 0; i < 10; i++) count[i] = 0;

            for(int num : nums){
                int index = (num / exp) % 10;
                count[index]++;
            }
            for(int i = 1; i < 10; i++) count[i] += count[i - 1];

            for(int i = n -1; i >= 0; i--){
                int digit = (nums[i] / exp) % 10;
                output[count[digit] - 1] = nums[i];
                count[digit]--;
            }

            System.arraycopy(output, 0, nums, 0, n);
            exp *= 10;
        }
    }

    public static int getMax(int[] nums){
        int max = nums[0];
        for(int i : nums) if(i > max) max = i;
        return max;
    }

    public static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void allRadixSort(int[] nums){

        int negatives_count = 0;
        for(int i : nums) if(i < 0) negatives_count++;

        int n = nums.length;
        int[] negatives = new int[negatives_count];
        int[] positives = new int[n - negatives_count];

        int i = 0, j = 0;
        for(int num : nums){
            if(num < 0) {
                negatives[j] = -num;
                j++;
            }else{
                positives[i] = num;
                i++;
            }
        }

        radixSort(negatives);
        radixSort(positives);

        int[] output = new int[n];
        int index = 0;

        for(i = negatives_count - 1; i >= 0; i--){
            output[index] = -negatives[i];
            index++;
        }
        for(i = 0; i < n - negatives_count; i++){
            output[index] = positives[i];
            index++;
        }

        System.arraycopy(output, 0, nums, 0, n);
    }

    public static void main(String[] args){
        int[] nums = {123, 34, 56, 12, 899, 1000, 456};
        radixSort(nums);
        printArray(nums);

        int[] allNums = new int[15];
        Random random = new Random();
        for(int i = 0; i < allNums.length; i++){
            allNums[i] = random.nextInt(-100, 100);
        }
        allRadixSort(allNums);
        printArray(allNums);
    }

}
