package leetcode.one;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
}

class Solution_1 {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if( nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}

class Solution_2 {
    public int[] twoSum(int[] nums, int target) {
        //맵 생성
        Map<Integer, Integer> numsMap = new HashMap<>();
        //입력된 배열의 값, 인덱스를 각각 키, value로 입력
        for (int i=0; i< nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        for (int i=0; i<nums.length; i++) {
            //target - 값을 키로 갖고있으며, 현재 인덱스가 아닐 경우 답으로 반환
            if(numsMap.containsKey(target-nums[i]) && i != numsMap.get(target-nums[i]))
                return new int[]{i, numsMap.get(target - nums[i])};
        }
        return null;
    }
}

class Solution_3 {
    public int[] twoSum(int[] nums, int target) {
        //맵 생성
        Map<Integer, Integer> numsMap = new HashMap<>();
        //입력된 배열의 값, 인덱스를 각각 키, value로 입력
        for (int i=0; i< nums.length; i++) {
            if(numsMap.containsKey(target-nums[i]) && i != numsMap.get(target-nums[i]))
                return new int[]{i, numsMap.get(target - nums[i])};
            numsMap.put(nums[i], i);
        }
        return null;
    }
}