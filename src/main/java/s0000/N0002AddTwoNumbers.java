package s0000;

import me.rainstorm.ds.ListNode;
import me.rainstorm.util.ListNodeUtil;
import org.junit.Test;

import static me.rainstorm.util.ListNodeUtil.buildListNode;

/**
 * [2] 两数相加
 * <p>
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 * <p>
 * algorithms
 * Medium (33.62%)
 * Total Accepted:    108K
 * Total Submissions: 320.9K
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author baochen1.zhang
 * @date 2019.04.02
 */
public class N0002AddTwoNumbers {

    @Test
    public void case1() {
        ListNode l1 = buildListNode(new int[]{2, 4, 3});
        ListNode l2 = buildListNode(new int[]{5, 6, 4});

        assert "708".equals(ListNodeUtil.toString(addTwoNumbers(l1, l2)));
    }

    @Test
    public void case2() {
        ListNode l1 = buildListNode(new int[]{9, 9});
        ListNode l2 = buildListNode(new int[]{1});

        assert "001".equals(ListNodeUtil.toString(addTwoNumbers(l1, l2)));
    }

    @Test
    public void case3() {
        ListNode l1 = buildListNode(new int[]{1});
        ListNode l2 = buildListNode(new int[]{9, 9});

        assert "001".equals(ListNodeUtil.toString(addTwoNumbers(l1, l2)));
    }

    @Test
    public void case4() {
        ListNode l1 = buildListNode(new int[]{0});
        ListNode l2 = buildListNode(new int[]{9, 9});

        assert "99".equals(ListNodeUtil.toString(addTwoNumbers(l1, l2)));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, false);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2, boolean overflow) {
        if (l1 == null && l2 == null) {
            if (overflow) {
                return new ListNode(1);
            } else {
                return null;
            }
        }
        if (l1 == null) {
            if (overflow) {
                return addTwoNumbers(new ListNode(1), l2);
            } else {
                return l2;
            }
        }
        if (l2 == null) {
            if (overflow) {
                return addTwoNumbers(new ListNode(1), l1);
            } else {
                return l1;
            }
        }
        int sum = l1.val + l2.val;
        if (overflow) {
            sum += 1;
        }
        l2.val = sum % 10;
        l2.next = addTwoNumbers(l1.next, l2.next, sum > 9);
        return l2;
    }
}
