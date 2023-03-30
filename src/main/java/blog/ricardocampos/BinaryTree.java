package blog.ricardocampos;

import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTree {

  public static void main(String[] args) {
    Nodee node40 = new Nodee(40);
    node40.left = new Nodee(25);

    Nodee node70 = new Nodee(70);
    node70.left = new Nodee(64);

    Nodee node60 = new Nodee(60);
    node60.left = node40;
    node60.right = node70;

    Nodee node90 = new Nodee(90);
    node90.left = new Nodee(85);
    node90.right = new Nodee(120);

    Nodee root = new Nodee(80);
    root.left = node60;
    root.right = node90;

    // UPDATE HERE WITH NEW INPUT VALUES
    int k = 83;

    // input=20 - search should be 25: ok
    // input=60 - search should be 60: ok
    // input=83 - search should be 85: ok
    // input=88 - search should be 90: ok
    // input=87 - search should be 85: ok
    // input=1000000 - search should be 120: ok
    // input=105 - search should be 90: ok

    AtomicInteger minList = new AtomicInteger(Integer.MAX_VALUE);

    // Input
    System.out.println("input: " + k);

    // Run the search
    searchNext(root, k, minList);

    // Output
    System.out.println("search: " + minList);
  }

  private static void searchNext(Nodee root, int k, AtomicInteger minList) {
    if (root.left != null) {
      searchNext(root.left, k, minList);
    }

    int lastDiff = minList.get() - k;
    if (lastDiff < 0) lastDiff = lastDiff * -1;

    int newDiff = root.value - k;
    if (newDiff < 0) newDiff = newDiff * -1;

    if (newDiff < lastDiff) {
      minList.set(root.value);
    }

    if (root.right != null) {
      searchNext(root.right, k, minList);
    }
  }
}

class Nodee {
  public Nodee(int value) {
    this.value = value;
  }

  int value;
  Nodee left;
  Nodee right;
}
