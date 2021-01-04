package s0000;

import me.rainstorm.ds.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 *
 * @author traceless
 */
public class N0025ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode tail = head;
        for (int count = 0; count < k; count++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }

        ListNode newHead = reverse(head, tail);
        head.next = reverseKGroup(tail, k);

        return newHead;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode cur = head;

        ListNode tmp;
        while (cur != tail) {
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}
