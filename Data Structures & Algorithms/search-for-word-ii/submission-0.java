class Solution {

    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean endOfWord = false;
    } 

    public void addWordToTrie(String word, TrieNode root){
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            int ascii = c - 'a';
            if(curr.children[ascii] == null){
                curr.children[ascii] = new TrieNode();
            }
            curr = curr.children[ascii];
        }
        curr.endOfWord = true;
    }

    private Set<String> res;
    private Set<Pair<Integer, Integer>> path;
    private Integer COLS;
    private Integer ROWS;
    private char[][] board;


    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        this.path = new HashSet<>();
        this.res = new HashSet<>();
        this.COLS = board[0].length-1;
        this.ROWS = board.length -1;
        this.board = board;

        for(String word: words){
            addWordToTrie(word, root);
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                dfs(i, j, root, "");
            }
        }
        return new ArrayList(res);
    }


    public void dfs(int r, int c, TrieNode curr, String word){
        

       
        Pair<Integer, Integer> pair = new Pair<>(r,c);

if(r>ROWS || r < 0 || c > COLS || c < 0 || curr.children[board[r][c] - 'a'] == null || path.contains(pair)){
            return;
        }
         int ascii = board[r][c] - 'a';
        path.add(pair);

        curr = curr.children[ascii];

        word += board[r][c];

        if(curr.endOfWord){
            res.add(word);
        }

 

        dfs(r+1, c, curr, word);

        dfs(r-1, c, curr, word);

        dfs(r, c+1, curr, word);

        dfs(r, c-1, curr, word);

        path.remove(pair);

        

    }

    


}
