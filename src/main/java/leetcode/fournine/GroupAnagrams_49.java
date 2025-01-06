package leetcode.fournine;

import java.util.*;

public class GroupAnagrams_49 {
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for(String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = String.valueOf(charArray);
            if(!res.containsKey(s)){
                res.put(s, new ArrayList<>());
            }
            res.get(s).add(str);
        }

        return new ArrayList<>(res.values());
    }
}
