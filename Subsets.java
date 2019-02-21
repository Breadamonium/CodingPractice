//#78 https://leetcode.com/problems/subsets/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> finalAnswer = new ArrayList<ArrayList<Integer>>():
        finalAnswer.add(new ArrayList<Integer>)();
        
        ArrayList<Integer> initialNums = new ArrayList<Integer>(Arrays.asList(nums));
        finalAnswer.addAll(recursiveSwap(initialNums));
        return finalAnswer;
    }
    
    public List<List<Integer>> recursiveSwap(List<Integer> numsToSwap) {
        List<List<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        if (numsToSwap.size() == 1) {
            answer.add(numsToSwap);
            return answer;
        }
        else if (numsToSwap.size() == 2) {
            answer.add(numsToSwap);
            answer.add(Collections.reverse(numsToSwap));
            return answer;
        }
        else {
            for (int i = 0; i < numsToSwap.size(); i++) {
                List<Integer> numsWithoutCurrent = numsToSwap;
                numsWithoutCurrent.remove(i);
                List<List<Integer>> recursiveResult = recursiveSwap(numsWithoutCurrent);
                for (int j = 0; j < recursiveResult.size(); j++) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(numsToSwap.get(i));
                    temp.addAll(recursiveResult.get(j));
                    answer.add(temp);
                }
            }
            return answer;
        }
    }
}
