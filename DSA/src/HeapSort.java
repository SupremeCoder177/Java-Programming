public class HeapSort {

    public static int[] heapSort(int[] nums){
        int[] heap = new int[nums.length];
        int n = nums.length;
        System.arraycopy(nums, 0, heap, 0, n);
        int index = n - 1;
//        while(index < n){
//            heap[index] = nums[index];
//            int parent = (index - 1) / 2;
//            int child = index;
//
//            while(parent >= 0){
//                if(heap[parent] < heap[child]){
//                    int temp = heap[child];
//                    heap[child] = heap[parent];
//                    heap[parent] = temp;
//                    child = parent;
//                    parent = (child - 1) / 2;
//                }else{
//                    break;
//                }
//            }
//            index++;
//        }
//        index--;
        heap = heapify(heap);
        while(index > 0){

            int temp = heap[0];
            heap[0] = heap[index];
            heap[index] = temp;

            int parent = 0;
            while(parent < index){
                int left_child = 2 * parent + 1;
                int right_child = 2 * parent + 2;
                int max = parent;
                if(left_child < index && heap[left_child] > heap[max]) max = left_child;
                if(right_child < index && heap[right_child] > heap[max]) max = right_child;

                if(max == left_child){
                    int copy = heap[left_child];
                    heap[left_child] = heap[parent];
                    heap[parent] = copy;

                }else if(max == right_child){
                    int copy = heap[right_child];
                    heap[right_child] = heap[parent];
                    heap[parent] = copy;
                }else{
                    break;
                }
                parent = max;
            }
            index--;
        }
        return heap;
    }

    public static int[] heapify(int[] nums){
        int index = nums.length - 1;
        int[] heap = nums;
        while(index > 0){
            int parent = (index - 1) / 2;
            if(heap[parent] < heap[index]){
                int temp = heap[index];
                heap[index] = heap[parent];
                heap[parent] = temp;
            }
            index--;
        }
        return heap;
    }

    public static void main(String[] args){
        int[] nums = {100, -1, 23, 30, 2, 2, 1, 0};

//        int[] temp = heapify(nums);
//        for(int i : temp) System.out.print(i + " ");
//        System.out.println();

        int[] newNums = heapSort(nums);
        for(int i : newNums) System.out.print(i + " ");
    }
}
