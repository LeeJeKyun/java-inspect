package leetcode.onefive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
}

class Solution_mine {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for(int j=i+1; j<nums.length; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> set = new ArrayList<>();
                        set.add(nums[i]);
                        set.add(nums[j]);
                        set.add(nums[k]);
                        result.add(set);
                    }
                }
            }
        }
        return result;
    }
}
