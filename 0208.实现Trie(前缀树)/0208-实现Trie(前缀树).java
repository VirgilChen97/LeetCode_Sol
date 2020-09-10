import java.util.*;

class Trie {
    class node{
        Character val;
        boolean isKey = false;
        Map<Character, node> child;
        public node(Character val){
            this.val = val;
            child = new HashMap<>();
        }
    }
    node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new node(' ');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] now = word.toCharArray();
        node ptr = root;
        for(int i = 0; i < now.length; i++){
            if(ptr.child.containsKey(now[i])){
                ptr = ptr.child.get(now[i]);
            }else{
                ptr.child.put(now[i], new node(now[i]));
                ptr = ptr.child.get(now[i]);
            }
            if(i == now.length - 1){
                ptr.isKey = true;
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] now = word.toCharArray();
        node ptr = root;
        for(int i = 0; i < now.length; i++){
            if(ptr.child.containsKey(now[i])){
                ptr = ptr.child.get(now[i]);
            }else{
                return false;
            }
        }
        return ptr.isKey?true:false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] now = prefix.toCharArray();
        node ptr = root;
        for(int i = 0; i < now.length; i++){
            if(ptr.child.containsKey(now[i])){
                ptr = ptr.child.get(now[i]);
            }else{
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */