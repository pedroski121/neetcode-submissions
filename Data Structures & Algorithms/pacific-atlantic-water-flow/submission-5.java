class Solution {

    int ROWS;
    int COLS;

    int[][] directions = {{1,0}, {-1,0}, {0, 1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        this.ROWS = heights.length;
        this.COLS = heights[0].length;

        boolean[][] atl = new boolean[ROWS][COLS];
        boolean[][] pac = new boolean[ROWS][COLS];

        for(int i = 0; i < COLS; i++){
            dfs(0, i, pac, heights);

            dfs(ROWS - 1, i, atl, heights);   
        }

        for(int j = 0; j < ROWS; j++) {
            dfs(j, 0, pac, heights);

            dfs(j, COLS - 1, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(atl[i][j] && pac[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    public void dfs(int r, int c, boolean[][] oceans, int[][] heights){
        oceans[r][c] = true;

        for(int[] d: directions){
            int nr = r + d[0];
            int nc = c + d[1];

            if(nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && !oceans[nr][nc] && heights[nr][nc] >= heights[r][c] ){
                dfs(nr, nc, oceans, heights);
            }
        }

    }
}