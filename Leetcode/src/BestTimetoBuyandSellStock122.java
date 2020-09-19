public class BestTimetoBuyandSellStock122 {
    public static void main(String[] args) {
        int[] prices = new int[]{6,1,3,4,7};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        int multipleMax = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {

                if (prices[j] - prices[i] > multipleMax) {
                    multipleMax = prices[j] - prices[i];
                }
//                if (prices[j] - prices[i] > 0) {
//                    max += prices[j] - prices[i];
//                    if (max > multipleMax) {
//                        i = j + 1;
//                    }
//                }
            }
        }
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {

                if (prices[j] - prices[i] > 0) {
                    max += prices[j] - prices[i];
                        i = j + 1;
                }
            }
        }
        if (max > multipleMax) {
            return max;
        } else
            return multipleMax;

    }
}
