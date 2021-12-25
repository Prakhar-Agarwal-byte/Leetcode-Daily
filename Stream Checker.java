class StreamChecker {
  Node root = new Node('/', false);
  StringBuilder sb = new StringBuilder();
  int maxLen = 0;

  public StreamChecker(String[] words) {
    for (int i = 0; i < words.length; i++) {
      maxLen = Math.max(maxLen, words[i].length());
      int j = words[i].length() - 1;
      Node cur = root;
      while (j >= 0) {
        int c = words[i].charAt(j)-'a';
        if (cur.arr[c] == null) {
          cur.arr[c] = new Node(c, false);
        }
        cur = cur.arr[c];
        j--;
      }
      cur.isEndOfWord = true;
    }
  }

  public boolean query(char letter) {
    if (sb.length() > maxLen) {
      sb.deleteCharAt(sb.length() - 1);
    }
    sb.insert(0, letter);
    Node cur = root;
    int i = 0;
    while (cur != null && i < sb.length()) {
      cur = cur.arr[sb.charAt(i++)-'a'];
      if (cur != null && cur.isEndOfWord == true)
        return true;
    }
    return false;
  }
}

class Node {
  int val;
  boolean isEndOfWord;
  Node[] arr;

  Node(int val, boolean isEndOfWord) {
    this.val = val;
    this.isEndOfWord = isEndOfWord;
    arr = new Node[26];
  }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
