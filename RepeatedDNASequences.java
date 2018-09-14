class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> answerArray = new ArrayList<String>();
        HashSet<String> seen = new HashSet<String>();
        HashSet<String> answers = new HashSet<String>();
        for (int i = 0; i <= s.length()-10; i++) {
            String current = s.substring(i, i+10);
            if (!seen.contains(current)) {
                seen.add(current);
            } else {
                answers.add(current);
            }
        }
        for (String seq: answers) {
            answerArray.add(seq);
        }
        return answerArray;
    }
}