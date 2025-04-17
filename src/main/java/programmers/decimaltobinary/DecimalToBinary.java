package programmers.decimaltobinary;

import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        int decimal = 123;
        System.out.println(Solution.solution(decimal));
    }
}

class Solution {
    public static String solution(int decimal) {
        Stack<Integer> stack = new Stack<>();
        while(decimal != 0) {
            stack.push(decimal%2);
            decimal /= 2;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(String.valueOf(stack.pop()));
        }
        return sb.toString();
    }
}
