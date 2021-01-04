package s0000;

import me.rainstorm.ds.ListNode;

/**
 * sen ->  first -> second -> third
 * sen -> second -> first -> third
 * <p>
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * @author traceless
 */
public class N0024SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        //加一个哨兵节点
        ListNode sen = new ListNode(0, head);
        ListNode prev = sen;
        ListNode first;
        while (prev.next != null && prev.next.next != null) {
            first = prev.next;
            prev.next = first.next;
            first.next = first.next.next;
            prev.next.next = first;
            prev = first;
        }
        return sen.next;
    }
}
