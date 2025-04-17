package programmers.parentheses;

import java.util.Stack;

public class Parentheses {
    public static void main(String[] args) {
        String s = "()(()()()()())"; //true
        String s1 = "()(()()()()()))"; //false
        String s2 = ")()(()()()()()))"; //false
        System.out.println(Solution.solution(s));
        System.out.println(Solution.solution(s1));
        System.out.println(Solution.solution(s2));
    }
}

class Solution {
    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        for(char c : charArray) {
            if(c == '(') {
                stack.push('c');
            } else {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
