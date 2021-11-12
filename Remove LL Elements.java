class Solution {
  public ListNode removeElements(ListNode head, int val) {
    ListNode d = new ListNode();
    ListNode dCur = d;
    ListNode cur = head;
    while (cur != null) {
      if (cur.val != val) {
        dCur.next = new ListNode(cur.val);
        dCur = dCur.next;
      }
      cur = cur.next;
    }
    return d.next;
  }
}
