public class LC24两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        ListNode next = cur.next;
        ListNode last;
        while (cur != null && next != null) {
            last = next.next;
            pre.next = next;
            next.next = cur;
            cur.next = last;
            pre = cur;
            cur = last;
            next = cur == null ? null : cur.next;
        }
        return dummy.next;
    }
}
