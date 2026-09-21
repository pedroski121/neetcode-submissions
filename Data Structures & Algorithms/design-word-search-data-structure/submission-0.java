public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

class WordDictionary {

    private TrieNode root; 

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            int c = word.charAt(i) - 'a';
            if(curr.children[c] == null){
                curr.children[c] = new TrieNode();
            }
            curr = curr.children[c];
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int j, TrieNode root){
        TrieNode curr = root;
   
        for(int i = j; i < word.length(); i++){
            char c = word.charAt(i);

        if(c == '.'){
            for (TrieNode child: curr.children){
                if(child != null && dfs(word, i + 1, child)){
                    return true;
                }
            }
            return false;
        } else {
            int diff = c - 'a';
            if(curr.children[diff] == null ){
                return false;
            }
            curr = curr.children[diff];
        }
        }
        return curr.endOfWord;
    }
}
