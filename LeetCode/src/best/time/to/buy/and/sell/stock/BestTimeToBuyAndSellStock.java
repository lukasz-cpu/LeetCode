package best.time.to.buy.and.sell.stock;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = new int[]{2, 1, 4, 5, 3};
        maxProfit(prices);
    }

    public static int maxProfit(int[] prices) {
        int temp = Integer.MAX_VALUE;
        int overallProfit = 0;
        int profitIfSoldToday;

        for (int price : prices) {
            if (price < temp) {
                temp = price;
            }
            profitIfSoldToday = price - temp;
            if (overallProfit < profitIfSoldToday) {
                overallProfit = profitIfSoldToday;
            }
        }
        return overallProfit;
    }
}

