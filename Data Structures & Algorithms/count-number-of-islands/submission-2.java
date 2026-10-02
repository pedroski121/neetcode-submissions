class Solution {

    private int ROWS;
    private int COLS;
    private char[][] grid;

    public int numIslands(char[][] grid) {
        this.ROWS = grid.length - 1;
        this.COLS = grid[0].length - 1;
        this.grid = grid;
        int res = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j){
        if(i < 0 || i > ROWS || j < 0 || j > COLS || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';

        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);


    }


}
