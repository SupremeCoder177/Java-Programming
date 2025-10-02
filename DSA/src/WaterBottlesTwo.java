public class WaterBottlesTwo {

    public static int drink(int empty, int exchange, int filled){
        if(empty - exchange >= 0) {
            return drink(empty - exchange, exchange + 1, filled + 1);
        }
        else{
            if(filled + empty - exchange >= 0){
                return filled + drink(empty + filled, exchange, 0);
            }else{
                return filled;
            }
        }
    }

    public static int maxBottleDrunk(int numBottles, int numsExchange){
        if(numsExchange > numBottles) return numBottles;
        return drink(numBottles, numsExchange, 0) + numBottles;
    }

    public static void main(String[] args){
        System.out.println(maxBottleDrunk(13, 6));
    }

}
