public class LC23合并K个升序链表 {
    //分治算法
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }
        return process(lists, 0, n - 1);
    }
    //分
    public ListNode process(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode l = process(lists, left, mid);
        ListNode r = process(lists, mid + 1, right);
        return merge(l, r);
    }
    //治
    public ListNode merge(ListNode l1, ListNode l2) {
        //这里其实就是合并两条链表的算法
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

}
