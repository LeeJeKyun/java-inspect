package leetcode.onetwoone;

public class BestTimeToBuyAndSellStock_121 {

    public static void main(String[] args) {
        int[] input = new int[]{8,1,5,3,6,4};
        Solution solution = new Solution();
        int answer = solution.maxProfit(input);
        System.out.println("answer = " + answer);
    }

}

class Solution {
    public int maxProfit(int[] prices) {

        int max = 0;
        int min = prices[0];
        for(int price : prices) {
            min = Math.min(min, price);
            max = Math.max(max, price-min);
        }

        return max;
    }
}
