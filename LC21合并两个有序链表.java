public class LC21合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//方法一：递归
        //特判
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
//方法二：迭代
//        ListNode res = new ListNode();
//        ListNode cur = res;
//        while (list1 != null && list2 != null) {
//            if (list1.val <= list2.val) {
//                cur.next = list1;
//                list1 = list1.next;
//            } else {
//                cur.next = list2;
//                list2 = list2.next;
//            }
//            cur = cur.next;
//        }
//        if (list1 == null) {
//            cur.next = list2;
//        }
//        if (list2 == null) {
//            cur.next = list1;
//        }
//        return res.next;
    }
}
