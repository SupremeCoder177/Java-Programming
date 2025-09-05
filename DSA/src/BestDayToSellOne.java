public class BestDayToSellOne {
    // this was my solution
    public static int maxProfit(int[] prices){
        int min_day = prices[0];
        int min_day_index = 0;
        int max_day = prices[prices.length - 1];
        int max_day_index = prices.length - 1;

        for(int i = 0; i < prices.length; ++i){
            if(prices[i] < min_day && i < max_day_index) {
                min_day = prices[i];
                min_day_index = i;
            }else if(prices[i] < min_day && i > max_day_index){
                int temp_min = prices[i];
                for(int j = i; j < prices.length; ++j){
                    if(prices[j] - temp_min > max_day - min_day){
                        max_day = prices[j];
                        max_day_index = j;
                        min_day = temp_min;
                        min_day_index = i;
                        break;
                    }
                }
            }
            if(prices[i] > max_day && i > min_day_index){
                max_day = prices[i];
                max_day_index = i;
            }
        }

        return Math.max(max_day - min_day, 0);
    }


    //this was chatGPT's
//    public static int maxProfit(int[] prices) {
//        int minPrice = prices[0];
//        int maxProfit = 0;
//
//        for (int i = 1; i < prices.length; i++) {
//            if (prices[i] < minPrice) {
//                minPrice = prices[i];
//            } else {
//                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
//            }
//        }
//
//        return maxProfit;
//    }

    public static void main(String[] args){
        int profit = maxProfit(new int[]{5, 6, 1, 3});
        System.out.println(profit);
    }
}
