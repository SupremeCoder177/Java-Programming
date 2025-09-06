import java.util.Random;

public class BSearch{

    public static int binarySearch(int[] nums, int target, boolean sorted){
        if(!sorted){
            BubbleSort.bubbleSort(nums);
            for (int num : nums) {
                System.out.print(num + " ");
            }
        }
        int pointer = (nums.length - 1) / 2;
        int endPointer = nums.length - 1;
        int startPointer = 0;
        
        while(startPointer <= endPointer){
            if(target < nums[pointer]){
                endPointer = pointer + 1;
                pointer = ((endPointer - startPointer) / 2) + startPointer;
            }
            else if(target > nums[pointer]){
                startPointer = pointer - 1;
                pointer = ((endPointer - startPointer) / 2) + startPointer;
            }
            else break;
        }
        return pointer;
    }

    public static void main(String[] args) {
        int[] nums = new int[100];
        Random random = new Random();
        for(int i = 0; i < nums.length; i++){
            nums[i] = random.nextInt(0, 100);
        }
        System.out.println();
        System.out.println("Searching....");

        int output = binarySearch(nums, 22, false);
        System.out.println();
        System.out.println(output);
    }

}