class MinStack {

  Node head;

  public MinStack() {
  }

  public void push(int val) {
    int min;
    if (head == null) {
      min = val;
    } else {
      min = Math.min(val, head.min);
    }
    Node node = new Node(val, min);
    node.next = head;
    head = node;
  }

  public void pop() {
    head = head.next;
  }

  public int top() {
    return head.val;
  }

  public int getMin() {
    return head.min;
  }
}

class Node {
  int val;
  int min;
  Node next;

  Node(int val, int min) {
    this.val = val;
    this.min = min;
  }
}
