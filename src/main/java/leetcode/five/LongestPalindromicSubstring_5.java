package leetcode.five;

public class LongestPalindromicSubstring_5 {
}

class Solution {
    int left, maxLen;

    public String longestPalindrome(String s) {
        //투포인터로 접근
        //2칸짜리와 3칸짜리 투포인터를 이용하여 팰린드롬인지 확인
        //팰린드롬일 경우 좌,우로 한칸씩 확장하여 팰린드롬인지 계속해서 확인

        int len = s.length();
        if (len < 2) return s;

        for(int i=0; i<len -1; i++) {
            extendPalindrome(s, i, i + 1);
            extendPalindrome(s, i, i + 2);
        }

        return s.substring(left, left+maxLen);
    }

    public void extendPalindrome(String s, int left, int right) {
        //
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        if(maxLen < right - left - 1) {
            this.left = left + 1;
            maxLen = right - left - 1;
        }
    }
}