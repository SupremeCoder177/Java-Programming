public class MysticDungeon {

    public static int maximumEnergy(int[] energy, int k){
        int max = Integer.MIN_VALUE;
        int n = energy.length;
        for(int i = n - k; i < n; i++){
            int temp = 0;
            for(int j = i; j >= 0; j -= k){
                temp += energy[j];
                max = Math.max(max, temp);
            }
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(maximumEnergy(new int[]{5, 2, -10, -5, 1}, 3));
    }
}
