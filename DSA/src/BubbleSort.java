public class BubbleSort{

    public static void bubbleSort(int[] nums){
        for(int i = nums.length -1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] target = new int[100];

        for(int i = 0; i < 100; i++){
            target[i] = (int)(Math.random() * 100) % 30;
        }
        bubbleSort(target);
        for(int i : target) System.out.print(i + " ");
    }

}