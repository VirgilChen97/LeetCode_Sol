import java.util.LinkedHashMap;

class LRUCache extends LinkedHashMap<Integer, Integer>{
    int capacity;
    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return getOrDefault(key, -1);
    }
    
    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}