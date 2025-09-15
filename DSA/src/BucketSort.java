import java.util.*;

public class BucketSort {

    public static void bucketSort(int[] nums, int bucketSize){

        if(nums == null || nums.length == 0 || bucketSize <= 0) return;

        int max = nums[0];
        int min = nums[0];

        for(int value : nums){
            if(value < min) min = value;
            if(value > max) max = value;
        }

        double range = Math.ceil( (double) ((max - min) + 1) / bucketSize);

        List<Integer>[] buckets = new LinkedList[bucketSize];

        for(int i = 0; i < bucketSize; i++){
            buckets[i] = new LinkedList<>();
        }

        for(int value : nums){
            int bucketIndex = (int) ((value - min) / range);
            buckets[bucketIndex].add(value);
        }

        for(List<Integer> bucket : buckets){
            Collections.sort(bucket);
        }

        int index = 0;
        for(List<Integer> bucket : buckets){
            for(int value : bucket){
                nums[index] = value;
                index++;
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {0, 1, 2, 3, 1, 45, 10 ,23, 13, 54, 233, 65, 23, 76, 25, 167, 49};
        bucketSort(nums, 10);

        for(int i : nums) System.out.print(i + " ");
        System.out.println();
    }

}
