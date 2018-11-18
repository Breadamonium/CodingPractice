//Leetcode #264 https://leetcode.com/problems/ugly-number-ii
class UglyNumber2 {
    
    HashMap<Integer, Boolean> memoized = new HashMap<Integer, Boolean>();
    
    public int nthUglyNumber(int n) {
        List<Integer> uglies = new ArrayList<Integer>();
        int bounds = n;
        for (int i = 1; i <= n; i++) {
            if (uglies.size() == bounds) {
                break;
            }
            if (isUglies(i)) {
                memoized.put(i, true);
                uglies.add(i);
            }
            else{
                memoized.put(i, false);
                n++;
            }
        }
        return uglies.get(bounds - 1);
    }
    
    public boolean isUglies(int n) {
        
        while(n!=1){
            if (memoized.containsKey(n)){
                return memoized.get(n);
            }
            else if (n%2 ==0) {
                n = n/2;
            }
            else if (n%3 == 0) {
                n = n/3;
            }
            else if (n%5 == 0) {
                n= n/5;
            }
            else {
                return false;
            }
        }
        return true;
    }
}