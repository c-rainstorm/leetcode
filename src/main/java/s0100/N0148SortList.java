package s0100;

import me.rainstorm.ds.ListNode;
import me.rainstorm.util.ListNodeUtil;
import org.junit.Test;

/**
 * [148] 排序链表
 * <p>
 * https://leetcode-cn.com/problems/sort-list/description/
 * <p>
 * algorithms
 * Medium (59.07%)
 * Total Accepted:    10.9K
 * Total Submissions: 18.4K
 * Testcase Example:  '[4,2,1,3]'
 * <p>
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * @author baochen1.zhang
 * @date 2019.04.20
 */
public class N0148SortList {

    @Test
    public void case1() {
        ListNode root = sortList(ListNodeUtil.buildListNode(new int[]{4, 2, 1, 3}));
        assert isSorted(root);
    }

    @Test
    public void case2() {
        ListNode root = sortList(ListNodeUtil.buildListNode(new int[]{-1, 5, 3, 4, 0}));
        assert isSorted(root);
    }

    private boolean isSorted(ListNode root) {
        if (root == null) {
            return true;
        }

        ListNode cur = root;
        while (cur.next != null) {
            if (cur.val > cur.next.val) {
                return false;
            }
            cur = cur.next;
        }

        return true;
    }


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMidNode(head);

        ListNode firstPart = head;
        ListNode secondPart = mid.next;
        mid.next = null;
        firstPart = sortList(firstPart);
        secondPart = sortList(secondPart);

        return merge(firstPart, secondPart);
    }

    private ListNode merge(ListNode firstPart, ListNode secondPart) {
        if (firstPart == null && secondPart == null) {
            return null;
        }
        if (firstPart == null) {
            return secondPart;
        }
        if (secondPart == null) {
            return firstPart;
        }

        ListNode head = firstPart.val < secondPart.val ? firstPart : secondPart;

        ListNode firstIndex = head == firstPart ? firstPart.next : firstPart;
        ListNode secondIndex = head == secondPart ? secondPart.next : secondPart;

        ListNode root = head;

        while (firstIndex != null && secondIndex != null) {
            while (firstIndex != null && firstIndex.val <= secondIndex.val) {
                root.next = firstIndex;
                firstIndex = firstIndex.next;
                root = root.next;
            }
            while (firstIndex != null && secondIndex != null && firstIndex.val > secondIndex.val) {
                root.next = secondIndex;
                secondIndex = secondIndex.next;
                root = root.next;
            }
        }
        if (firstIndex == null) {
            root.next = secondIndex;
        } else {
            root.next = firstIndex;
        }

        return head;
    }

    private ListNode findMidNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode stepOne = head;
        ListNode stepTwo = head.next;

        while (stepTwo != null && stepTwo.next != null) {
            stepTwo = stepTwo.next.next;
            stepOne = stepOne.next;
        }

        return stepOne;
    }
}
