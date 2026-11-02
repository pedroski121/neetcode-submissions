class Solution {

    private Integer ROWS;
    private Integer COLUMNS;
    private char[][] layout;

    public int numIslands(char[][] grid) {
        this.ROWS = grid.length - 1;
        this.COLUMNS = grid[0].length-1;
        this.layout = grid;
        int res = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    dfs(i,j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(int i, int j){
        if(i < 0 || i > ROWS || j < 0 || j > COLUMNS || layout[i][j] != '1'){
            return;
        }
        layout[i][j] = '0';

        dfs(i + 1, j);
        dfs(i-1, j);
        dfs(i, j + 1);
        dfs(i, j-1);
    }
}
