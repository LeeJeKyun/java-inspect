package leetcode.string.eightonenine;

import java.util.*;

public class MostCommonWord_819 {
    public static void main(String[] args) {
        String paragraph = "a.";
        String[] banned = new String[]{""};

        Solution solution = new Solution();

        System.out.println(solution.mostCommonWord(paragraph,banned));
    }
}


class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        Set<String> ban = new HashSet<>(Arrays.asList(banned));

        Map<String, Integer> counts = new HashMap<>();

        //입력 문자열에서 단어 문자가 아닌 것을 공백으로 변환하고 모두 소문자로 변경 후 단어단위 배열로 변환한다.
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");
        for (String a : words) {
            System.out.println("a = " + a);
        }

        for (String w : words) {
            if(!ban.contains(w)) {
                counts.put(w, counts.getOrDefault(w, 0) + 1);
            }
        }

        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}