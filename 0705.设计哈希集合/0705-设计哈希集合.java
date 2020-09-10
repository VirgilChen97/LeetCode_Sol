import java.util.*;

class MyHashSet {

    /** Initialize your data structure here. */
    List<List<Integer>> lists;

    public MyHashSet() {
        lists = new ArrayList<>();
        for (int i = 0; i < 1024; i++) {
            lists.add(new LinkedList<>());
        }
    }

    public void add(int key) {
        List<Integer> now = lists.get(key % 1024);
        for (int i = 0; i < now.size(); i++) {
            if(now.get(i) == key){
                return;
            }
        }
        now.add(key);
    }

    public void remove(int key) {
        List<Integer> now = lists.get(key % 1024);
        for (int i = 0; i < now.size(); i++) {
            if(now.get(i) == key){
                now.remove(i);
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int position = key % 1024;
        return lists.get(position).contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */