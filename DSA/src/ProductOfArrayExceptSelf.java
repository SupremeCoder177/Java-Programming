import java.util.ArrayList;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int[] output = new int[nums.length];
        ArrayList<Integer> zeroes = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; ++i){
            if (nums[i] != 0) product *= nums[i];
            else zeroes.add(i);
        }
        for(int i = 0; i < nums.length;i++){
            if(zeroes.size() > 1) {output[i] = 0; continue;}
            else{
                if(zeroes.isEmpty()){
                    output[i] = product / nums[i];
                }else{
                    output[i] = i == zeroes.get(0) ? product : 0;
                }
            }
        }

        return output;
    }

    public static void main(String[] args){
        int[] output = productExceptSelf(new int[]{2, 1, 2, 1, 3});
        for(int i : output){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
