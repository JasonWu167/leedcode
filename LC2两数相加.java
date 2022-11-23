public class LC2两数相加 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
// // 定义total记录两个数的和
// 		int total = 0;
// 		// 定义next记录是否进一
// 		int next = 0;
// 		// 定义返回的链表
// 		ListNode result = new ListNode();
// 		// 定义一个临时指针
// 		ListNode cur = result;
        //先加到短链表
// 		while (l1 != null && l2 != null) {
// 			total = l1.val + l2.val + next;
// 			cur.next = new ListNode(total % 10);
// 			next = total / 10;
// 			l1 = l1.next;
// 			l2 = l2.next;
// 			cur = cur.next;
// 		}
        //补全
// 		while (l1 != null) {
// 			total = l1.val + next;
// 			cur.next = new ListNode(total % 10);
// 			next = total / 10;
// 			l1 = l1.next;
// 			cur = cur.next;
// 		}
// 		while (l2 != null) {
// 			total = l2.val + next;
// 			cur.next = new ListNode(total % 10);
// 			next = total / 10;
// 			l2 = l2.next;
// 			cur = cur.next;
// 		}
        //判断是否还有进位
// 		if (next != 0) {
// 			cur.next = new ListNode(next);
// 		}
// 		return result.next;
//     }

        int total = l1.val + l2.val;
        int next = total / 10;
        ListNode result = new ListNode(total % 10);
        if (l1.next != null || l2.next != null || next != 0) {
            //如果不为空则按当前值，如果为空补成0
            l1 = l1.next = l1.next != null ? l1.next : new ListNode(0);
            l2 = l2.next = l2.next != null ? l2.next : new ListNode(0);
            l1.val += next;
            result.next = addTwoNumbers(l1, l2);
        }
        return result;
    }
}

