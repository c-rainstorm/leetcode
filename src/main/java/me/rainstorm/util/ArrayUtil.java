package me.rainstorm.util;

import java.util.StringJoiner;

/**
 * @author baochen1.zhang
 * @date 2019.04.03
 */
public class ArrayUtil {

    public static String toString(Integer[] nums, String delimiter) {
        StringJoiner joiner = new StringJoiner(delimiter);
        if (nums == null) {
            joiner.add("null");
            return joiner.toString();
        }
        for (Integer num : nums) {
            joiner.add(String.valueOf(num));
        }
        return joiner.toString();
    }

    public static String buildStr(int[] nums, int len) {
        StringBuilder builder = new StringBuilder();
        int length = Math.min(nums.length, len);
        for (int i = 0; i < length; ++i) {
            builder.append(nums[i]);
        }
        return builder.toString();
    }

    public static String toString(Integer[] tree) {
        return toString(tree, ",");
    }
}
