import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReplaceNonCoPrimes {

    public static int firstFactor(int x){
        for(int i = 2; i <= x; i++){
            if(x % i == 0) return i;
        }
        return 1;
    }


    public static ArrayList<Integer> factors(int x){
        ArrayList<Integer> output = new ArrayList<>();

        while(x != 1){
            int temp = firstFactor(x);
            output.add(temp);
            x /= temp;
        }

        return output;
    }

    public static boolean checkCommonFactors(int num1, int num2){
        ArrayList<Integer> tmp1 = factors(num1);
        ArrayList<Integer> tmp2 = factors(num2);

        for(int i : tmp1) if(tmp2.contains(i) && i != 1) return true;
        return false;
    }

    public static List<Integer> getCommonFactors(int num1, int num2){
        ArrayList<Integer> factors1 = factors(num1);
        ArrayList<Integer> factors2 = factors(num2);
        ArrayList<Integer> output = new ArrayList<>();
        int ptr1 = 0, ptr2 = 0;
        int size1 = factors1.size();
        int size2 = factors2.size();

        while(ptr1 < size1 && ptr2 < size2){
            if(Objects.equals(factors1.get(ptr1), factors2.get(ptr2))) {
                int temp = factors1.get(ptr1);
                while(true){
                    output.add(temp);
                    if(ptr1 + 1 >= size1) break;
                    if(ptr2 + 1 >= size2) break;
                    if(factors1.get(ptr1 + 1) != temp && factors2.get(ptr2 + 1) != temp) break;
                    else{
                        if(factors1.get(ptr1 + 1) == temp){
                            ptr1++;
                        }else{
                            ptr2++;
                        }
                    }
                }
            }
            ptr1++;
            ptr2++;
        }
        while(ptr1 < size1){
            if(num1 % factors1.get(ptr1) == 0 || num2 % factors1.get(ptr1) == 0) output.add(factors1.get(ptr1));
            ptr1++;
        }
        while(ptr2 < size2){
            if(num1 % factors2.get(ptr2) == 0 || num2 % factors2.get(ptr2) == 0) output.add(factors2.get(ptr2));
            ptr2++;
        }
        return output;
    }

    public static int lcm(int num1, int num2){
        if(num1 % num2 == 0) return num1;
        if(num2 % num1 == 0) return num2;

        int output = 1;

        for(int i : getCommonFactors(num1, num2)){
            output *= i;
        }
        return output;
    }


    public static List<Integer> replaceNonCoprimes(int[] nums){
        List<Integer> output = new ArrayList<>();
        int index = -1;
        for(int i = 0; i < nums.length; i++){
            if(output.isEmpty()){
                if(i < nums.length - 1 && checkCommonFactors(nums[i], nums[i + 1])){
                    output.add(lcm(nums[i], nums[i + 1]));
                    i++;
                }else{
                    output.add(nums[i]);
                }
                index++;
            }else{
                int tmp = output.get(index);
                if(checkCommonFactors(tmp, nums[i])){
                    output.remove(index);
                    output.add(lcm(tmp, nums[i]));
                }
                else if(i < nums.length - 1 && checkCommonFactors(nums[i], nums[i + 1])) {
                    output.add(lcm(nums[i], nums[i + 1]));
                    index++;
                    i++;
                }
                else{
                    output.add(nums[i]);
                    index++;
                }
            }
        }
        return output;
    }

    public static void printList(List<Integer> e){
        for(int i : e) System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args){
        int[] nums = {11,13,13,13,30,516,2,6};
        printList(factors(30));
        printList(factors(516));
        printList(getCommonFactors(30, 516));
        System.out.println(lcm(30, 516));
        List<Integer> output = replaceNonCoprimes(nums);
        printList(output);
    }

}
