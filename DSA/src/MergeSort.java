public class MergeSort {

    public static void mergeSort(int[] nums){
        if(nums.length <= 1) return;

        int middle = nums.length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[nums.length - middle];

        int i = 0;
        int j = 0;
        for(;i < nums.length; i++){
            if(i < middle){
                leftArray[i] = nums[i];
            }else{
                rightArray[j] = nums[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, nums);
    }

    public static void merge(int[] leftArray, int[] rightArray, int[] array){
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0;

        while(l < leftSize && r < rightSize){
            if(leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                i++;
                l++;
            }else{
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while(l < leftSize){
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightSize){
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }

    public static void main(String[] args){
        int[] nums = {10, 4, 5, 9, 2, 49, 2, 1};
        mergeSort(nums);
        for(int i : nums){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
