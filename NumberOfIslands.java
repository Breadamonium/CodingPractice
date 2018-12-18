// https://leetcode.com/problems/number-of-islands/solution/ #200

class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        HashMap<Coordinate, List<Coordinate>> islands = new HashMap<Coordinate, List<Coordinate>>();
        for (int i = 0; i<grid[0].length; i++) {
            for (int j = 0; j<grid.length; j++) {
                if (grid[j][i] == '1') {
                    System.out.println("test");
                    Coordinate next = new Coordinate(j, i);
                    BFShelper(grid, next);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }
    
    public class Coordinate {
        int x;
        int y;
        
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public void BFShelper(char[][] grid, Coordinate start) {
        Queue<Coordinate> seen = new LinkedList<Coordinate>();
        while (!seen.isEmpty()) {
            Coordinate next = seen.poll();
            grid[next.x][next.y] = '0';
            if (!(next.x + 1 >= grid.length)) {
                if (grid[next.x + 1][next.y] == '1') {
                    seen.add(new Coordinate(next.x + 1, next.y));
                }
            }
    
            if (!(next.y + 1 >= grid[0].length)) {
                if (grid[next.x][next.y + 1] == '1') {
                    seen.add(new Coordinate(next.x, next.y + 1));
                }
            }
            if (!(next.x - 1 < 0)) {
                if (grid[next.x - 1][next.y] == '1') {
                    seen.add(new Coordinate(next.x - 1, next.y));
                }
            }
            if (!(next.y - 1 <0)) {          
                if (grid[next.x][next.y - 1] == '1') {
                    seen.add(new Coordinate(next.x, next.y - 1));
                }
            }
        }
    }
}