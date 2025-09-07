public class SumZero {

    public static int[] sumZero(int n){
        if(n == 1) return new int[]{0};
        int[] output = new int[n];

        for(int i = 0; i < n / 2; i++){
            output[i * 2] = i;
            output[(i * 2) + 1] = -i;
        }

        output[0] = n + 1;
        output[1] = -(n + 1);

        return output;
    }

    public static void main(String[] args){
        int[] output = sumZero(6);

        for(int i : output) System.out.print(i + " ");

    }
}
