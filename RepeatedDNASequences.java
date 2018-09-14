class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> answerArray = new ArrayList<String>();
        HashSet<String> repeats = new HashSet<String>();
        HashSet<String> answers = new HashSet<String>();
        for (int i = 0; i < s.length(); i++) {
            String current = s.substring(i, i+10);
            System.out.println(current);
            if (repeats.contains(current)) {
                answers.add(current);
            }
        }
        for (String seq: answers) {
            answerArray.add(seq);
        }
        return answerArray;
    }
}