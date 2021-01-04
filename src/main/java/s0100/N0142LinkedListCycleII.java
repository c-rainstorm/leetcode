package s0100;

import me.rainstorm.ds.ListNode;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * @author traceless
 */
public class N0142LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        // 步骤一：使用快慢指针判断链表是否有环
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if (!hasCycle) {
            return null;
        }

        // 步骤二：若有环，找到入环开始的节点
        ListNode cur = head;
        while (cur != slow) {
            cur = cur.next;
            slow = slow.next;
        }
        return cur;
    }
}
