package s0100;

import me.rainstorm.ds.ListNode;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author traceless
 */
public class N0141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
