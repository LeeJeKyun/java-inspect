package programmers.failurerate;

import java.util.*;

public class FailureRate {
    //실패율
    public static void main(String[] args) {
        int N = 5;
        int[] stages = new int[]{2,1,2,6,2,4,3,3};

        int[] result = Solution.solution(N, stages);
        for(int i : result) {
            System.out.print(i + " ");
        }

    }
}

class Solution {
    public static int[] solution(int N, int[] stages) {
        //머무르는 스테이지 배열
        int[] stayStages = new int[N + 2];
        //결과값 배열
        HashMap<Integer, Double> failureMap = new HashMap<>();

        //stages만큼 반복하여 머무르는 스테이지 배열 생성
        for(int i : stages) {
            stayStages[i]++;
        }

        //실패율 계산을 위한 분모
        double denominator = stages.length;
        //스테이지별 실패율로 변환
        for(int i=1; i<=N; i++) {
            if(stayStages[i] == 0) {
                failureMap.put(i, 0.);
            } else {
                failureMap.put(i, stayStages[i] / denominator);
                denominator -= stayStages[i];
            }
        }

        ArrayList<Map.Entry<Integer, Double>> entries = new ArrayList<>(failureMap.entrySet());
        int[] result = entries.stream().sorted((o1, o2) -> o1.getValue().equals(o2.getValue())
                ? Integer.compare(o1.getKey(), o2.getKey())
                : Double.compare(o2.getValue(), o1.getValue())).mapToInt(Map.Entry::getKey).toArray();

        return result;
    }
}

class SolutionAnswer {
    public static int[] solution(int N, int[] stages) {
        int[] challenger = new int[N + 2];
        for (int stage : stages) {
            challenger[stage] += 1;
        }

        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;

        for (int i = 1; i <= N; i++) {
            if (challenger[i] == 0) {
                fails.put(i, 0.);
            } else {
                fails.put(i, challenger[i] / total);
                total -= challenger[i];
            }
        }

        return fails.entrySet().stream().sorted((o1, o2) ->
                o1.getValue().equals(o2.getValue())
                        ? Integer.compare(o1.getKey(), o2.getKey())
                        : Double.compare(o2.getValue(), o1.getValue()))
                .mapToInt(Map.Entry::getKey).toArray();
    }
}