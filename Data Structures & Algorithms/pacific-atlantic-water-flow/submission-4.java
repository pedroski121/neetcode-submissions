class Solution {
    int ROWS;
    int COLS;

    private int[][] directions = {
        {1,0}, 
        {-1, 0}, 
        {0, 1}, 
        {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.ROWS = heights.length;
        this.COLS = heights[0].length;

        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for(int c = 0; c < COLS ; c++){
            dfs(0, c, pac, heights);
            dfs(ROWS - 1, c, atl, heights);
        }

        for(int r = 0; r < ROWS; r++){
            dfs(r, 0, pac, heights);
            dfs(r, COLS - 1, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < pac.length; i++){
            for(int j = 0; j < atl[0].length; j++){
                if(pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights){
        ocean[r][c] = true;


        for(int[] d: directions) {
            int nr = r + d[0];
            int nc = c + d[1];

            if(nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && !ocean[nr][nc] && heights[r][c] <= heights[nr][nc] ){
                dfs(nr, nc, ocean, heights);
            }
        }
    }
}
