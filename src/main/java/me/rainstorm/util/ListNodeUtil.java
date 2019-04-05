package me.rainstorm.util;

import me.rainstorm.ds.ListNode;

/**
 * @author baochen1.zhang
 * @date 2019.04.05
 */
public class ListNodeUtil {

    public static ListNode buildListNode(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        ListNode head = new ListNode(nums[0]);
        ListNode tmp = head;
        for (int i = 1; i < nums.length; ++i) {
            tmp.next = new ListNode(nums[i]);
            tmp = tmp.next;
        }
        return head;
    }


    public static String toString(ListNode head) {
        StringBuilder builder = new StringBuilder();
        ListNode tmp = head;
        while (tmp != null) {
            builder.append(tmp.val);
            tmp = tmp.next;
        }
        return builder.toString();
    }
}
