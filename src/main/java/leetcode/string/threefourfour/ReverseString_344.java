package leetcode.string.threefourfour;

public class ReverseString_344 {
    public static void main(String[] args) {
        char[] arr = new char[]{'r', 'a', 'c', 'e', 'c', 'e', 'r'};
        Solution solution = new Solution();
        solution.reverseString(arr);
        for(char c : arr) {
            System.out.println(c);
        }
    }
}

class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;

        while(start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}