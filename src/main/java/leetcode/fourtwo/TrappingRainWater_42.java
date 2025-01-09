package leetcode.fourtwo;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater_42 {

}

class Solution_TwoPointer {
    public int trap(int[] height) {
        int volume = 0;
        int left = 0;
        int right = height.length-1;
        int leftMax = height[left];
        int rightMax = height[right];

        while(left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            //더 높은 쪽을 향해 투 포인터 이동
            if (leftMax <= rightMax) {
                //왼쪽 막대 최대 높이와의 차이를 더하고 왼쪽 포인터 이동
                volume += leftMax - height[left];
                left += 1;
            } else {
                volume += rightMax - height[right];
                right -= 1;
            }
        }
        return volume;
    }
}

class Solution_Stack {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int volume = 0;

        for (int i = 0; i<height.length; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer top = stack.pop();

                if(stack.isEmpty()) break;
                int distance = i - stack.peek() - 1;

                int waters = Math.min(height[i], height[stack.peek()]) - height[top];

                volume += distance * waters;
            }

            stack.push(i);
        }
        return volume;
    }
}