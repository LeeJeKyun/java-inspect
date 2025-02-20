package programmers.developeapp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DevelopApp {

    public static void main(String[] args) {
        int[] progresses = new int[]{93, 30, 55};
        int[] speeds = new int[]{1, 30, 5};
        Solution a = new Solution();
        int[] answer = a.solution(progresses, speeds);
        for(int i : answer) {
            System.out.println("i = " + i);
        }
    }

}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> resultList = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();

        for(int i=0; i<progresses.length; i++) {
            int remain = 100-progresses[i];
            if(remain%speeds[i]==0) queue.add(remain/speeds[i]);
            else queue.add(remain/speeds[i] + 1);
        }

        //앞에 있는 배포일의 최대값
        int max = queue.pop();
        int deploy = 1;
        while(!queue.isEmpty()){
            Integer pop = queue.pop();
            if(max < pop) {
                max = pop;
                resultList.add(deploy);
                deploy=1;
            } else {
                deploy++;
            }
        }
        resultList.add(deploy);
        int[] result = new int[resultList.size()];
        for(int i = 0; i<result.length; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
