package blog.ricardocampos;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Author: Oleh Yatskiv
 */
public class LRUCache {

  private final int queueSize;
  private final LinkedHashMap<String, String> queue;

  public LRUCache(int queueSize) {
    this.queueSize = queueSize;
    this.queue =
        new LinkedHashMap<>(queueSize, 0.75f, true) {
          @Override
          protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
            return size() > queueSize;
          }
        };
  }

  public void put(String key, String value) {
    queue.put(key, value);
  }

  public String get(String key) {
    return queue.getOrDefault(key, null);
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
