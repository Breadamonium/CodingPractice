//Leetcode #685 https://leetcode.com/problems/redundant-connection-ii/
//nonworking
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        HashMap<Integer, Integer> seen = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> inGraph = new HashMap<Integer, Integer>();
        int[]edgeToRemove = null;
        int root = -1;
        for (int[]anEdge: edges){
            int first = anEdge[0];
            int second = anEdge[1];
            System.out.print(first);
            System.out.print(" " + second);
            System.out.print(" " + !seen.containsKey(second));
            
            if (!seen.containsKey(second)){
                if (seen.containsValue(second)) {
                    System.out.print("CV");
                    if(edgeToRemove == null) {
                        edgeToRemove = anEdge;
                    }
                }
                System.out.print(" " + "PAIR" + second + first);
                seen.put(second, first);
                System.out.print(" removed " + first);
                if(inGraph.containsKey(first)) {
                    int occurrences = inGraph.get(first) + 1;
                    inGraph.put(first, occurrences);
                }
                else{
                    inGraph.put(first, 1);
                }
            }
            else {
                System.out.print(" outOfGraph: " + first);
                edgeToRemove = anEdge;
                if(inGraph.containsKey(first)) {
                    int occurrences = inGraph.get(first) - 1;
                    inGraph.put(first, occurrences);
                }
                else {
                    inGraph.put(first, 0);
                }
            }
            System.out.println();
         }
         if (inGraph.containsKey(edgeToRemove[0])&&(inGraph.get(edgeToRemove[0])<1)) {
            System.out.println("tesT");
            for (int[]anEdge: reverseArray(edges)){
                int first = anEdge[0];
                int second = anEdge[1];
                if (!seen.containsKey(second)){
                    if (seen.containsValue(second)) {
                        if(edgeToRemove == null) {
                            edgeToRemove = anEdge;
                        }
                    }
                    seen.put(second, first);
                }
                else {
                    edgeToRemove = anEdge;
                    seen.put(second, first);
                }
             }
         }
         return edgeToRemove;
    }
    
    public int[][] reverseArray(int[][] toReverse){
        int[][] answer = new int[toReverse.length][2];
        for (int i = 0; i<toReverse.length; i++){
            answer[toReverse.length - i - 1][0] = toReverse[i][0];
            answer[toReverse.length - i - 1][1] = toReverse[i][1];
        }
        return answer;
    }
}