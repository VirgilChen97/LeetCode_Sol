import java.util.*;

class MyHashMap {
    class Node{
        public int key;
        public int value;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    List<List<Node>> lists = new ArrayList<>();
    /** Initialize your data structure here. */
    public MyHashMap() {
        for(int i = 0; i<1024;i++){
            lists.add(new LinkedList<>());
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        List<Node> now = lists.get(key % 1024);
        for(int i = 0; i < now.size(); i++){
            if(now.get(i).key == key){
                now.get(i).value = value;
                return;
            }
        }
        now.add(new Node(key, value));
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        List<Node> now = lists.get(key % 1024);
        for(int i = 0; i < now.size(); i++){
            if(now.get(i).key == key){
                return now.get(i).value;
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        List<Node> now = lists.get(key % 1024);
        for(int i = 0; i < now.size(); i++){
            if(now.get(i).key == key){
                now.remove(i);
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */