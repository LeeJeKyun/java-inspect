package leetcode.onetwoone

fun maxProfit(prices: IntArray): Int {
    var maxProfit = 0
    var min  = prices[0]
    for(price in prices) {
        min = min.coerceAtMost(price)
        maxProfit = maxProfit.coerceAtLeast(price - min)
    }
    return maxProfit
}