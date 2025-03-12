package leetcode.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses_20 {
}

class Solution {
    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        Map<Character, Character> table = new HashMap<>();
        table.put(')', '(');
        table.put('}', '{');
        table.put(']', '[');

        for(char c : s.toCharArray()) {
            if(!table.containsKey(c)) stack.push(c);
            else if (stack.isEmpty() || table.get(c) != stack.pop()) {
                return false;
            }
        }

        return stack.size() == 0;

    }
}