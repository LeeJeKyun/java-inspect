package programmers.samenumber;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SameNumber {
    public static void main(String[] args) {
//        int[] arr = new int[] {1,1,3,3,0,1,1};
        int[] arr = new int[] {0,4,4,3,3};
        Solution solution = new Solution();
        int[] answer = solution.solution(arr);
        for(int i : answer) {
            System.out.print(i + " ");
        }
    }
}

class Solution{
    public int[] solution(int[] arr) {
        Deque<Integer> queue = new ArrayDeque<>();
        List<Integer> resultList = new ArrayList<>();

        for(int a : arr) {
            queue.add(a);
        }

        Integer prev = -1;
        while(!queue.isEmpty()) {
            Integer now = queue.pop();
            if(prev == now) {
                prev = now;
                continue;
            } else {
                resultList.add(now);
                prev = now;
            }
        }

        int[] result = new int[resultList.size()];
        for(int i = 0; i<result.length; i++) {
            result[i] = resultList.get(i);
        }

        return result;

    }
}

