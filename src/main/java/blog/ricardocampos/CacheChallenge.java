package blog.ricardocampos;

import java.util.HashMap;
import java.util.Map;

public class CacheChallenge {

  public CacheChallenge(Integer queueSize) {
    this.queueSize = queueSize;
  }

  private final Map<String, Item> queue = new HashMap<>();
  private final Integer queueSize;

  public void put(String key, String value) {
    if (queue.size() == queueSize) {
      // Always remove the least used element, in this case, at the end of the queue

      String keyToRemove = null;
      for (Map.Entry<String, Item> entry : queue.entrySet()) {
        if (entry.getValue().getPosition().equals(queueSize - 1)) {
          keyToRemove = entry.getKey();
          break;
        }
      }

      queue.remove(keyToRemove);
    }

    // Update all items positions
    for (Map.Entry<String, Item> entry : queue.entrySet()) {
      entry.getValue().setPosition(entry.getValue().getPosition() + 1);
    }

    // Always put in the position 0 [zero] (zero is the beginning of the queue, the most recent one)
    queue.put(key, new Item(value));
  }

  public String get(String key) {
    // Update all items positions - Send each element to one position behind
    if (queue.size() > 1 && queue.containsKey(key)) {
      for (Map.Entry<String, Item> entry : queue.entrySet()) {
        entry.getValue().setPosition(entry.getValue().getPosition() + 1);
      }

      // Update touched item - Send it to the beginning
      queue.get(key).setPosition(0);
    }

    return queue.containsKey(key) ? queue.get(key).getValue() : null;
  }

  public static void main(String[] args) {
    CacheChallenge lruCache = new CacheChallenge(3);
    lruCache.put("1", "one");
    lruCache.put("2", "two");
    lruCache.put("3", "three");

    System.out.println("Getting 1: " + lruCache.get("1")); // "one"
    System.out.println("Getting 2: " + lruCache.get("2")); // "two"
    System.out.println("Getting 1: " + lruCache.get("1")); // "one"
    System.out.println("Getting 3: " + lruCache.get("3")); // "three"
    System.out.println("Getting 2: " + lruCache.get("2")); // "two"
    System.out.println("Getting 1: " + lruCache.get("1")); // "one"

    lruCache.put("4", "four");

    System.out.println(
        "Getting 3: "
            + lruCache.get("3")); // null, since 3 is the least recently used and 2 has been removed
    System.out.println("Getting 4: " + lruCache.get("4")); // "four"
  }
}

class Item {
  private final String value;
  private Integer position;

  public Item(String value) {
    this.value = value;
    this.position = 0;
  }

  public String getValue() {
    return value;
  }

  public Integer getPosition() {
    return position;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }
}
