package wbchen;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxProfit {

    public static void main(String[] args) {
        getMaxProfit(new double[] {2, 2.1, 1.9, 2.0, 2.4, 2.3, 2.2, 2.1, 2.2, 2.3});
    }

    public static void getMaxProfit(double[] price) {

        Deque<String> orderSequence = new ArrayDeque<>();
        for (int i = 0; i < price.length; i++) {
            // 记录极小值点
            double lowPointPrice = price[i];
            int lowPointIndex = i;
            // 尝试寻找极大值点
            while (i < price.length - 1 && price[i] < price[i + 1]) {
                i++;
            }
            if (i > lowPointIndex) {
                double highPointPrice = price[i];
                orderSequence.offer("BUY : " + lowPointPrice + " SELL : " + highPointPrice);
            }
        }

        while (!orderSequence.isEmpty()) {
            System.out.println(orderSequence.pollFirst());
        }
    }
}
