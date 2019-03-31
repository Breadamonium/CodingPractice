//https://leetcode.com/problems/friend-circles/ #547

class Solution {
    public int findCircleNum(int[][] M) {
        int[] seen = new int[M.length];
        int counter = 0;
        
        for (int j = 0; j < M.length; j++){
            if (seen[j]==0){
                bfs(seen, j, M);
                counter++;
            }
        }
        return counter;
    }
    
    public void bfs(int[] seen, int nextNum, int[][] M){
        seen[nextNum] = 1;
        Queue<Integer> next = new LinkedList<>();
        next.add(nextNum);
        
        while(!next.isEmpty()){
            int current = next.poll();
            for (int i = 0; i < M.length; i++) {
                if ((M[current][i]==1)&&(seen[i]==0)){
                    seen[i]=1;
                    System.out.println(i);
                    next.add(i);
                }
            }
        }
    }
}