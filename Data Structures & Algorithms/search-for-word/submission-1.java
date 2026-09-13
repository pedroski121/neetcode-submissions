class Solution {
 // initialize fields for constant values
        private int ROW;
        private int COL;
        private  char[][] board;
        private  String word;
        private  Set<Pair<Integer, Integer>> path;

    public boolean exist(char[][] board, String word) {

        this.ROW = board.length - 1;
        this.COL = board[0].length - 1;
        this.board = board;
        this.word = word;
        this.path = new HashSet<>();


        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++) {
                if(dfs(i,j,0)){
                    return true;
                }
            }
        }
        return false;
        
    }

    public boolean dfs(int r, int c, int i) {
        // base case - character index == word length
        if(i == word.length()){
            return true;
        }
        // create a coordinate for current values being checked 
        Pair coord = new Pair<>(r,c);

        // cases when the condition fails 
        // -> if row or column is out of bounds
        // -> if current word character does not match the coordinate
        // if coordinate is already been passed
        if(
            path.contains(coord) || r < 0 || 
            r > this.ROW || c < 0 || 
            c > this.COL || word.charAt(i) != board[r][c] ){
            return false;
        }
        path.add(coord);

        boolean res = dfs(r + 1, c, i + 1) || 
            dfs(r - 1, c, i + 1) || 
            dfs(r, c + 1, i + 1) || 
            dfs(r, c - 1, i + 1);
        
        path.remove(coord);

        return res;
    }
}
