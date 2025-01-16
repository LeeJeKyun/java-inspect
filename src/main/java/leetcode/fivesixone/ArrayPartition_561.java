package leetcode.fivesixone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayPartition_561 {
}

class Solution_one {
    public int arrayPairSum(int[] nums) {
        int result = 0;
        List<Integer> pair = new ArrayList<>();
        Arrays.sort(nums);
        for(int n : nums) {
            pair.add(n);
            if (pair.size() == 2) {
                result += Collections.min(pair);
                pair.clear();
            }
        }
        return result;
    }
}

class Solution_two {
    public int arrayPairSum(int[] nums) {
        int result = 0;
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i=i+2) {
            result += nums[i];
        }

        return result;
    }
}
