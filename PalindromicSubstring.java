//https://leetcode.com/problems/palindromic-substrings/description/ #647
class PalindromicSubstring {
    public int countSubstrings(String s) {
        char[] charString = s.toCharArray();
        HashMap<String, Integer> substrings = new HashMap<String, Integer>();
        int count = 0;
        for (int first = 0; first < charString.length; first++) {
            for (int second = first+1; second < charString.length+1; second++) {
                System.out.println(s.substring(first, second));
                 if(isPalindrome(s.substring(first,second))) {
                    count++;
                 }
            }
        }
        return count;
    }
  
    private boolean isPalindrome(String s) {
       String reversed = "";
       for (int i = s.length() - 1; i >= 0; i--) {
          reversed += Character.toString(s.charAt(i));
       }
       if (reversed.equals(s)) {
           return true;
       }
       else {
           return false;
       }
    }
}
