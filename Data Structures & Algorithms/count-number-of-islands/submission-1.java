class Solution {

    private int ROWS;
    private int COLS;
    private Set<Pair<Integer, Integer>> visited;
    public int numIslands(char[][] grid) {
        
        // iterate through every position in the grid 
            // if a value is 1
                // From that position, run dfs and move left, right, up, down. break if boundary is reached or value is 0
                // flip each visited island to 0
            // increment the number of islands
        
        this.ROWS = grid.length - 1;
        this.COLS = grid[0].length - 1;
        this.visited = new HashSet<>();
        int numberOfIslands = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
        
    }

    public void dfs(int r, int c, char[][] grid){
        
        if(r > ROWS || r < 0 || c > COLS || c < 0 || grid[r][c] == '0'){
            return;
        }

        // Pair<Integer, Integer> pair = new Pair<>(r,c);

        // if(visited.contains(pair)){
        //     return;
        // }
        
        // visited.add(pair);

        grid[r][c] = '0';

        dfs(r+1, c, grid);
        dfs(r-1, c, grid);
        dfs(r, c+1, grid);
        dfs(r, c-1, grid);

        // visited.remove(pair);
    }
}
