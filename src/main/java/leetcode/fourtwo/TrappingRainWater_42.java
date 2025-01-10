package leetcode.fourtwo;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater_42 {

    public static void main(String[] args) {
        Solution_mine solutionMine = new Solution_mine();
        System.out.println(solutionMine.trap(new int[]{1,1,0,2,1,0,1,3,2,1,2,1}));
    }

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
        //스택 생성(LIFO)
        Deque<Integer> stack = new ArrayDeque<>();
        //volume 선언(답)
        int volume = 0;

        //배열길이만큼 진행
        for (int i = 0; i<height.length; i++) {
            //스택이 비어있지 않고, 현재 인덱스의 배열이 스택값의 배열보다 큰 동안 진행
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                //top = 현재 index의 바로 왼쪽 인덱스
                Integer top = stack.pop();

                if(stack.isEmpty()) break;
                //거리 = 현재 인덱스 - 스택의 맨위값 - 1
                int distance = i - stack.peek() - 1;

                //물 = (현재 배열값, 스택값 주소의 배열값중 작은값) - 최대값
                int waters = Math.min(height[i], height[stack.peek()]) - height[top];

                //결과값에 거리 * 물을 더한다.
                volume += distance * waters;
            }

            stack.push(i);
        }
        return volume;
    }
}

class Solution_mine {

    //브루트포스로 로직 자체는 맞으나 시간복잡도가 높아 X
    public int trap(int[] height) {
        //volume(정답) 선언
        int volume = 0;
        for(int i=0; i<height.length; i++) {
            int leftMax = height[i];
            int rightMax = height[height.length-1];
            for(int j=0; j<=i; j++) {
                if(leftMax < height[j]) leftMax = height[j];
            }
            for(int j=height.length-1; j>i; j--) {
                if(rightMax < height[j]) rightMax = height[j];
            }
//            System.out.println("leftMax = " + leftMax);
//            System.out.println("rightMax = " + rightMax);
            if(leftMax >= rightMax && height[i] <= rightMax) volume += rightMax - height[i];
            else if(leftMax < rightMax && height[i] <= leftMax) volume += leftMax - height[i];
        }
        return volume;
    }
}