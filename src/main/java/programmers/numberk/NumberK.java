package programmers.numberk;

import java.util.Arrays;

public class NumberK {
    public static void main(String[] args) {
        int[] array = new int[]{1,5,2,6,3,7,4};
        int[][] commands = new int[][]{{2,5,3},{4,4,1},{1,7,3}};
        Solution s = new Solution();
        System.out.println(commands.length);

        int[] answer = s.solution(array, commands);
        for(int i : answer) {
            System.out.println("i = " + i);
        }
    }
}

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        for(int a=0; a<commands.length; a++) {
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];

            int[] sub = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(sub);
            System.out.println(" = ");
            result[a] = sub[k-1];
        }

        return result;
    }
}
