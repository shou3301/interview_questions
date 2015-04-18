/**
 * Implement a map that provides the following method:
 * get, put, remove, and getRandomValue, all requires O(1) time
 */

// This is not thread safe.
public class MyMap {
    
    private Map<String, String> map;
    
    private ArrayList<String> keys;
    
    private Map<String, Integer> keyIndex;
    
    public MyMap() {
        map = new HashMap<>();
        keys = new ArrayList<>();
        keyIndex = new HashMap<>();
    }
    
    public void put(String key, String value) {
        map.put(key, value);
        keys.add(key);
        keyIndex.put(key, keys.size() - 1);
    }
    
    public String get(String key) {
        return map.get(key);
    }
    
    public void remove(String key) {
        if (!keyIndex.containsKey(key)) return;
        
        int idx = keyIndex.get(key);
        keys.set(idx, keys.get(keys.size() - 1));
        keys.remove(keys.size() - 1);
        
        keyIndex.remove(key);
        map.remove(key);
    }
    
    public String getRandomValue() {
        int rand = new Random().nextInt(keys.size());
        return map.get(keys.get(rand));
    }
}
