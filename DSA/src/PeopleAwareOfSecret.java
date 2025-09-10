public class PeopleAwareOfSecret {

    public static int peopleAwareOfSecret(int n, int delay , int forget){
        if(n == 0) return 0;
        int num_people = 1;
        int count = 0;

        for(int i = 0; i < n; i++){
            if((i - 1) % delay == 0){
                num_people *= 2;
            }
            if((i - 1) % forget == 0){
                num_people -= (int)Math.pow(2, count);
                count++;
            }
        }
        return num_people;
    }

    public static void main(String[] args){
        System.out.println(peopleAwareOfSecret(6, 2, 4));
    }
}
