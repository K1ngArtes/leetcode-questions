class Solution {
    class Coord {
        int x;
        int y;
        
        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int numIslands(char[][] grid) {
        if(grid.length == 1) {
            if(grid[0][0] == '1') {
                return 1;
            } else {
                return 0;
            }
        }
        int islandNum = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        
        Queue<Coord> q = new LinkedList<Coord>();
        int numIslands = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '0' || visited[i][j]) {
                    // System.out.println("Removing: [" + i + " , " + j + "]");
                    continue;
                }
                
                
                // System.out.println("Starting an isalnd at: [" + i + " , " + j + "]");
                q.offer(new Coord(i, j));
                boolean gotIsland = false;
                while(!q.isEmpty()) {
                    Coord coord = q.poll();
                    if(visited[coord.x][coord.y]) {
                        continue;
                    }
                    visited[coord.x][coord.y] = true;
                    // System.out.println("Visiting: [" + coord.x + " , " + coord.y + "]");
                    if(grid[coord.x][coord.y] != '0') {
                        gotIsland = true;
                        // System.out.println("Grid[" + coord.x + "," + coord.y + "] " + "is: " + grid[coord.x][coord.y]);
                        getNeighbours(coord, q, new Coord(grid.length-1, grid[0].length-1));
                    }
                }
                if(gotIsland) {
                    // System.out.println("------------ISLAND DONE------------------");
                    numIslands++;   
                }
            }
        }
        
        return numIslands;
    }
    
    void getNeighbours(Coord coord, Queue<Coord> q, Coord d) {
        if(coord.x == 0 && coord.y == 0) { // top left
            q.offer(new Coord(0,1));   
            q.offer(new Coord(1,0));
        } else if(coord.x == 0 && coord.y == d.y) { // top right
            q.offer(new Coord(0,d.y-1));
            q.offer(new Coord(1,d.y));
        } else if(coord.x == d.x && coord.y == 0) { // bottom left
            q.offer(new Coord(d.x-1,0));
            q.offer(new Coord(d.x,1));
        } else if(coord.x == d.x && coord.y == d.y) { // bottom right
            q.offer(new Coord(d.x-1,d.y));
            q.offer(new Coord(d.x,d.y-1));
        } else if(coord.x == 0) { // top edge
            q.offer(new Coord(0,coord.y-1));
            q.offer(new Coord(0,coord.y+1));
            q.offer(new Coord(1,coord.y));
        } else if(coord.y == 0) { // left edge
            q.offer(new Coord(coord.x+1,0));
            q.offer(new Coord(coord.x-1,0));
            q.offer(new Coord(coord.x,1));
        } else if(coord.y == d.y) { // right edge
            q.offer(new Coord(coord.x-1,coord.y));
            q.offer(new Coord(coord.x+1,coord.y));
            q.offer(new Coord(coord.x,coord.y-1));
        } else if(coord.x == d.x) { // bottom edge
            q.offer(new Coord(coord.x,coord.y-1));
            q.offer(new Coord(coord.x,coord.y+1));
            q.offer(new Coord(coord.x-1,coord.y));
        } else { // the rest
            q.offer(new Coord(coord.x,coord.y-1));
            q.offer(new Coord(coord.x,coord.y+1));
            q.offer(new Coord(coord.x-1,coord.y));
            q.offer(new Coord(coord.x+1,coord.y));
        }
    }
}