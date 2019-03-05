// https://leetcode.com/problems/jewels-and-stones/submissions/
// #771

class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> jewels = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            jewels.add(J.charAt(i));
        }
        int counter = 0;
        for (int k = 0; k < S.length(); k++) {
            if (jewels.contains(S.charAt(k))) {
                counter++;
            }
        }
        return counter;
    }
}