//https://leetcode.com/problems/add-and-search-word-data-structure-design/


class WordDictionary {
    
    private TrieNode root = new TrieNode();

    class TrieNode {
        public TrieNode[] children;
         /** Initialize your data structure here. */
        public boolean leaf;
        public TrieNode() {
            children = new TrieNode[26];
        }
        
        public boolean containsKey(char ch) {
            return children[ch - 'a'] != null;
        }
        public TrieNode get(char ch) {
            return children[ch - 'a'];
        }
        public void put(char ch, TrieNode node) {
            children[ch - 'a'] = node;
        }

    }
    
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.leaf = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
    
    private boolean searchHelper(String word, int k, TrieNode node) {
        if (k == word.length()) {
            return node.leaf;
        }
        char c = word.charAt(k);
        if (c != '.') {
            return (node.containsKey(c) && searchHelper(word, k+1, node.get(c)));
        }
        else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (searchHelper(word, k+1, node.children[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */