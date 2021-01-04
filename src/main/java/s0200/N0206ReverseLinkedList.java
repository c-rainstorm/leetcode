package s0200;

import me.rainstorm.ds.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/submissions/
 *
 * @author traceless
 */
public class N0206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}