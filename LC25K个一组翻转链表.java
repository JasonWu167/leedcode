public class LC25K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;//特判
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            //找到结尾，若k比待反转部分长度大，返回结果
            for (int i = 0; i < k; i++) {
                end = end.next;
                if (end == null) return dummy.next;
            }
            //反转开始的节点
            ListNode start = pre.next;
            //下一次反转的节点开始
            ListNode next = end.next;
            //断链表
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    //反转链表
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode last = cur.next;
            cur.next = pre;
            pre = cur;
            cur = last;
        }
        return pre;
    }
}
