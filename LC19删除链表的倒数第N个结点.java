public class LC19删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //特判
        if (head == null) {
            return null;
        }
        //辅助节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;//当前节点的前一个
        ListNode cur = pre.next;//当前节点
        ListNode last = dummy;//先锋节点
        //先让先锋节点走n步
        for (int i = 0; i < n; i++) {
            last = last.next;
        }
        //当last的下一个为空时，就找到了要删除节点
        while (last.next != null) {
            pre = pre.next;
            cur = cur.next;
            last = last.next;
        }
        //断链表完成删除
        pre.next = cur.next;
        return dummy.next;
    }
}
