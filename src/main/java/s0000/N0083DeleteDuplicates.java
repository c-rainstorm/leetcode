package s0000;

import me.rainstorm.ds.ListNode;
import me.rainstorm.util.ListNodeUtil;
import org.junit.Test;

/**
 * [83] 删除排序链表中的重复元素
 * <p>
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
 * <p>
 * algorithms
 * Easy (44.65%)
 * Total Accepted:    21.8K
 * Total Submissions: 48.8K
 * Testcase Example:  '[1,1,2]'
 * <p>
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * @author baochen1.zhang
 * @date 2019.04.05
 */
public class N0083DeleteDuplicates {

    @Test
    public void case1() {
        ListNode head = ListNodeUtil.buildListNode(new int[]{1, 1, 2});
        assert "12".equals(ListNodeUtil.toString(deleteDuplicates(head)));
    }


    @Test
    public void case2() {
        ListNode head = ListNodeUtil.buildListNode(new int[]{1, 1, 2, 3, 3});
        assert "123".equals(ListNodeUtil.toString(deleteDuplicates(head)));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curNode = head;
        int val = curNode.val;
        while (curNode.next != null) {
            if (val == curNode.next.val) {
                curNode.next = curNode.next.next;
            } else {
                curNode = curNode.next;
                val = curNode.val;
            }
        }
        return head;
    }
}
