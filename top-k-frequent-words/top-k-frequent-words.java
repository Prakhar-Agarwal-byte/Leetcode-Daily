class Solution {
  public List<String> topKFrequent(String[] words, int k) {
    PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>() {
      public int compare(Node a, Node b) {
        int r = a.freq-b.freq;
        if (r != 0) return r;
        if (a.word.compareTo(b.word) < 0) return 1;
        if (a.word.compareTo(b.word) > 0) return -1;
        return 0;
      }
    });
    HashMap<String, Integer> map = new HashMap<>();
    for (String s: words) {
      map.put(s, map.getOrDefault(s, 0) + 1);
    }
    for (Map.Entry<String, Integer> e: map.entrySet()) {
      Node n = new Node(e.getKey(), e.getValue());
      minHeap.add(n);
      if (minHeap.size() > k) {
        minHeap.poll();
      } 
    }
    List<String> res = new LinkedList<>();
    while (!minHeap.isEmpty()) {
      res.add(0, minHeap.poll().word);
    }
    return res;
  }
}

class Node {
  String word;
  int freq;
  Node(String word, int freq) {
    this.word = word;
    this.freq = freq;
  }
}