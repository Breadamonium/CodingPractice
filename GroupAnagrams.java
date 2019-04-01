//https://leetcode.com/problems/group-anagrams/ #49
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();
        HashMap<String,Integer> anagrams = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++){
            String current = strs[i];
            isAnagramOfExisting(anagrams, answer, current);
        }
        return answer;
    }
    
    public void isAnagramOfExisting(HashMap<String, Integer> anagrams, List<List<String>> answer, String s) {
        char[] sorted = s.toCharArray();
        Arrays.sort(sorted);
        String resorted = String.valueOf(sorted);
        if (anagrams.containsKey(resorted)) {
            int index = anagrams.get(resorted);
            List<String> agroup = answer.get(index);
            agroup.add(s);
        }
        else{
            List<String> newGroup = new ArrayList<String>();
            newGroup.add(s);
            answer.add(newGroup);
            anagrams.put(resorted, answer.size()-1);
        }
    }
}
