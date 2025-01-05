package leetcode.onetwofive

fun isPalindrome(s: String): Boolean {
    var start = 0;
    var end = s.length - 1

    while(start < end) {
        when {
            !Character.isLetterOrDigit(s[start]) -> start++
            !Character.isLetterOrDigit(s[end]) -> end--
            else -> {
                if(Character.toLowerCase(s[start]) != Character.toLowerCase(s[end])) {
                    return false
                }
                start++
                end--
            }
        }
    }
    return true
}

fun main() {
    var s = "A man, a plan, a canal: Panama"
    if (isPalindrome(s).equals(true)) {
        println("O")
    }
}

