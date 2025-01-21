package leetcode.string.onetwofive;

public class ValidPalindrome_125 {



}

class Solution {
    public boolean isPalindrome(String s) {
        String factor = s.toLowerCase();
        int start = 0;
        int end = factor.length() - 1;
        while (start < end) {
            //start 포인터의 char가 영문자나 숫자가 아닐 경우
            if(!Character.isLetterOrDigit(factor.charAt(start))) {
                start++;
            } else if(!Character.isLetterOrDigit(factor.charAt(end))) {
                end--;
            } else {
                if(factor.charAt(start) != factor.charAt(end)){
                    return false;
                }
                start++;
                end--;
            }

        }

        return true;
    }
}