class Solution {
  public int getNumberOfBacklogOrders(int[][] orders) {
    PriorityQueue<Integer> buy = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> sell = new PriorityQueue<>();
    for (int[] o: orders) {
      if (o[2] == 0) {
        while (!sell.isEmpty() && sell.peek() <= o[0] && o[1] > 0) {
          sell.poll();
          o[1]--;
        }
        while (o[1] > 0) {
          buy.add(o[0]);
          o[1]--;        
        }
      } else {
        while (!buy.isEmpty() && buy.peek() >= o[0] && o[1] > 0) {
          buy.poll();
          o[1]--;
        }
        while (o[1] > 0) {
          sell.add(o[0]);
          o[1]--;        
        }
      }
    }
    int mod = 1000000007;
    return ((buy.size() % mod) + (sell.size() % mod)) % mod;
  }
}
