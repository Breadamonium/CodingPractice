// https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
// #159

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Character current1 = '_';
        Character current2 = '_';
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            int counter = 0;
            for (int i = j; i < s.length(); i++) {
                if (current1.equals('_')){
                    current1 = s.charAt(i);
                }
                else if ((current2 == null) && (s.charAt(i)!=current1)) {
                    current2 = s.charAt(i);
                }
                else if ((s.charAt(i)!=current1)&&(s.charAt(i)!=current2)) {
                    break;
                }
                else {
                    counter++;
                }
            }
            current1 = '_';
            current2 = '_';
            if (counter > max) {
                max = counter;
            }
        }
        return max;
    }
}