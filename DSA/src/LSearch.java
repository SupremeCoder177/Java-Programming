import java.util.Random;

public class LSearch {

    public static int linearSearch(int[] nums, int target){
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) return i;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = new int[100];
        Random random = new Random();
        for(int i = 0; i < 100; i++){
            nums[i] = random.nextInt(0, 100);
        }
        BubbleSort.bubbleSort(nums);
        for(int i : nums){
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(linearSearch(nums, 20));
    }
}
