package me.rainstorm.util;

/**
 * @author baochen1.zhang
 * @date 2019.04.03
 */
public class ArrayUtil {

    public static String buildStr(int[] nums, int len) {
        StringBuilder builder = new StringBuilder();
        int length = Math.min(nums.length, len);
        for (int i = 0; i < length; ++i) {
            builder.append(nums[i]);
        }
        return builder.toString();
    }
}
