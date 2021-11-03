import java.util.*;

class RandomizedSet {

  HashMap<Integer, Integer> map = new HashMap<>();
  ArrayList<Integer> list = new ArrayList<>();
  Random rand = new Random();

  public RandomizedSet() {

  }

  public boolean insert(int val) {
    if (map.containsKey(val))
      return false;
    map.put(val, list.size());
    list.add(val);
    return true;
  }

  public boolean remove(int val) {
    if (!map.containsKey(val))
      return false;
    if (map.get(val) < list.size() - 1) {
      int loc = map.get(val);
      int lastVal = list.get(list.size() - 1);
      list.set(loc, lastVal);
      map.put(lastVal, loc);
    }
    map.remove(val);
    list.remove(list.size() - 1);
    return true;
  }

  public int getRandom() {
    return list.get(rand.nextInt(list.size()));
  }
}
