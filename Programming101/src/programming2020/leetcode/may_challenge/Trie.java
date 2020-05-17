package programming2020.leetcode.may_challenge;


import java.util.HashMap;

class Trie {

    class TrieNode{
        char c;
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isLeaf;
        public TrieNode(){

        }
        public TrieNode(char c){
            this.c = c;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;
        for(int i =0;i<word.length(); i++){
            char c = word.charAt(i);
            TrieNode node;
            if(children.containsKey(c)){
                node = children.get(c);
            }else {
                node = new TrieNode(c);
                children.put(c, node);
            }
            children = node.children;
            if(i==word.length() -1){
                node.isLeaf = true;
            }
        }

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        if(node !=null && node.isLeaf){
            return true;
        }
        else return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(searchNode(prefix) == null){
            return false;
        }
        else return true;
    }

    public TrieNode searchNode(String word){
        HashMap<Character, TrieNode> children = root.children;
        TrieNode node = null;

        for(int i =0;i<word.length(); i++){
            char c = word.charAt(i);
            if(children.containsKey(c)){
                node = children.get(c);
                children = node.children;
            }else {
                return null;
            }
        }

        return null;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
