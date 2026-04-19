class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Map<Number, Set<Character>> rowHM = new HashMap<>();

        Map<Number, Set<Character>> colHM = new HashMap<>();

        Map<String, Set<Character>> gridSubBox = new HashMap<>();

        for(int i = 0; i < board.length; i++){
            rowHM.put(i, new HashSet<>());
            for(int j = 0; j < board[i].length; j++){
                char rowValue = board[i][j];
                if(rowValue == '.'){
                    continue;
                }
                if(rowHM.get(i).contains(rowValue)){
                    return false;
                }
                rowHM.get(i).add(rowValue);
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){

                if(!colHM.containsKey(j)){
                    colHM.put(j,new HashSet<>());
                }
                if(board[i][j] == '.'){
                    continue;
                }
                if(colHM.get(j).contains(board[i][j])){
                    return false;
                }
                colHM.get(j).add(board[i][j]);
            }
        }

        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                String key = i/3 + "" + j/3;
                if(!gridSubBox.containsKey(key)){
                    gridSubBox.put(key, new HashSet<>());
                }

                if(gridSubBox.get(key).contains(board[i][j])){
                    return false;
                }
                gridSubBox.get(key).add(board[i][j]);
            }
        }



    return true;
    }
}
