import java.util.*;

class RandomizedCollection {
    Map<Integer, Set<Integer>> rc;
    List<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        rc = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not
     * already contain the specified element.
     */
    public boolean insert(int val) {
        list.add(val);
        if (!rc.containsKey(val)) {
            rc.put(val, new HashSet<>());
            rc.get(val).add(list.size() - 1);
            return true;
        } else {
            rc.get(val).add(list.size() - 1);
            return false;
        }
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained
     * the specified element.
     */
    public boolean remove(int val) {
        Set<Integer> pos = rc.get(val);
        if (pos == null) {
            return false;
        }

        Iterator<Integer> it = pos.iterator();
        Integer firstPos = it.next();
        Integer lastNum = list.get(list.size() - 1);
        list.set(firstPos, lastNum);
        rc.get(lastNum).remove(list.size()-1);
        rc.get(val).remove(firstPos);

        if (firstPos < list.size() - 1) {
            rc.get(lastNum).add(firstPos);
        }
        if (rc.get(val).size() == 0) {
            rc.remove(val);
        }

        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection(); boolean param_1 =
 * obj.insert(val); boolean param_2 = obj.remove(val); int param_3 =
 * obj.getRandom();
 */