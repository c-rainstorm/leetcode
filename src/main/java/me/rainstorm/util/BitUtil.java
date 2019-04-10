package me.rainstorm.util;

/**
 * @author baochen1.zhang
 * @date 2019.04.10
 */
public class BitUtil {
    public static int countBit(int num) {
        int count = 0;
        int target = num;
        while (target != 0) {
            count++;
            target &= (target - 1);
        }
        return count;
    }
}
