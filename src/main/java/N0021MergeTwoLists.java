import me.rainstorm.ds.ListNode;

/**
 * @author baochen1.zhang
 * @date 2019.04.02
 *
 * @lc app=leetcode.cn id=21 lang=java
 * <p>
 * [21] 合并两个有序链表
 * <p>
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 * <p>
 * algorithms
 * Easy (53.58%)
 * Total Accepted:    56.3K
 * Total Submissions: 105K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 * <p>
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class N0021MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
