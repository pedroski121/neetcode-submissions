class TrieNode {
    TrieNode[] characters = new TrieNode[26];
    boolean endOfWord = false;
}

class PrefixTree {
    private TrieNode root;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            int charIndex = c - 'a';
            if(curr.characters[charIndex] == null){
                curr.characters[charIndex] = new TrieNode(); 
            }
            curr = curr.characters[charIndex];
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            int index = c - 'a';
            if(curr.characters[index] == null){
                return false;
            }
            curr = curr.characters[index];
        }
        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root; 
        for(char c: prefix.toCharArray()){
            int index = c - 'a';
            if(curr.characters[index] == null){
                return false;
            }
            curr = curr.characters[index];
        }
        return true;
    }
}
