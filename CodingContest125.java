List<Integer> ans = new ArrayList<>();
class tuple {
    int x;
    int y; 
    public tuple (int a, int b){
        this.x= a;
        this.y = b;
    }

}
public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {   
    int[] xAxis = new int[]{-1,0,1,0};
    int[] yAxis = new int[] {0,-1,0,1};
    HashSet<tuple> lampDict = new HashSet<tuple>();

    Arrays.sort(lamps, new Comparator<int[]>(){
        public int compare(int[] a, int[]b){
            return a[0] - b[0];
        }     
    });
    for (int[] lamp : lamps){

        tuple lampEntry = new tuple(lamp[0],lamp[1]);
        lampDict.add(lampEntry);

    }	

    queryFlag:
    for (int[] query : queries){
        for (int[] lampEntry : lamps){
            if (query[0] == lampEntry[0]){
                ans.add(1);
                for (int i = 0 ; i < 3 ; i++){
                    tuple neighbor = new tuple((query[0] + xAxis[i]),(query[1] + yAxis[i]));
                    if (lampDict.contains(neighbor)){
                        lampDict.remove(neighbor);
                    }
                }
                continue queryFlag;
            }
            else if (query[1] == lampEntry[1]){
                ans.add(1);
                for (int i = 0 ; i < 3 ; i++){
                    tuple neighbor = new tuple((query[0] + xAxis[i]),(query[1] + yAxis[i]));
                    if (lampDict.contains(neighbor)){
                        lampDict.remove(neighbor);
                    }
                }
                continue queryFlag;			
            }
            else if (Math.abs(query[0] - lampEntry[0]) == Math.abs(query[1] - lampEntry[1])){
                ans.add(1);
                tuple curr = new tuple(query[0], query[1]);
                for (int i = 0 ; i < 3 ; i++){
                    tuple neighbor = new tuple((query[0] + xAxis[i]),(query[1] + yAxis[i]));
                    if (lampDict.contains(neighbor)){
                        lampDict.remove(neighbor);
                    }
                }
                continue queryFlag;
            }
            else{
                continue;
            }
        }
        ans.add(-1);
        tuple curr = new tuple(query[0], query[1]);
        for (int i = 0 ; i < 3 ; i++){
            tuple neighbor = new tuple((query[0] + xAxis[i]),(query[1] + yAxis[i]));
            if (lampDict.contains(neighbor)){
                lampDict.remove(neighbor);
            }
        }
    }
    int[] ret = new int[ans.size()];
    for (int i = 0; i <ans.size(); i++) {
        ret[i] = ans.get(i);
    }
    return ret;
}