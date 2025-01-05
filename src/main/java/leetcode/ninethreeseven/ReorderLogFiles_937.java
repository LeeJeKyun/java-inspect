package leetcode.ninethreeseven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReorderLogFiles_937 {
}

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digitList = new ArrayList<>();
        List<String> letterList = new ArrayList<>();

        for(String log: logs) {
            if(Character.isDigit(log.split(" ")[1].charAt(0))) {
                digitList.add(log);
            } else {
                letterList.add(log);
            }
        }

        letterList.sort((s1, s2) -> {
            String[] s1x = s1.split(" ", 2);
            String[] s2x = s2.split(" ", 2);

            int compared = s1x[1].compareTo(s2x[1]);
            if(compared==0) {
                return s1x[0].compareTo(s2x[0]);
            } else {
                return compared;
            }
        });

        letterList.addAll(digitList);

        return letterList.toArray(new String[0]);
    }
}