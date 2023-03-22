package blog.ricardocampos;

class Second {

  /**
   * Given two strings, calculate how many strings equal can be constructed
   * using only letters from the other string.
   *
   * @param a String to construct, containing only lowercase English letters
   * @param b String containing needed letters, containing only lowercase English letters
   * @return The number of strings a that can be constructed from the string b
   */
  public static int stringsConstruction(String a, String b) {
    int count = 0;
    while (b.contains(a)) {
      b = b.replace(a, "");
      count++;
    }
    // mirror the string
    StringBuilder builder = new StringBuilder();
    for (int i=0, len=a.length(); i<len; i++) {
      builder.append(a.charAt(len-i-1));
    }
    System.out.println("Mirror: " + builder);
    while(b.contains(builder.toString())) {
      b = b.replace(builder.toString(), "");
      count++;
    }
    return count;
  }
}
