package me.rainstorm.util;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author baochen1.zhang
 * @date 2019.04.19
 */
public class SortUtil {

    public static int[] quick3way(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);

        return quick3way(array, 0, array.length - 1);
    }

    private static int[] quick3way(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return array;
        }
        int i = lo + 1;
        int lt = lo;
        int gt = hi;
        int v = array[lo];
        while (i < gt) {
            int cmp = array[i] - v;
            if (cmp < 0) {
                swap(array, lt++, i++);
            } else if (cmp > 0) {
                swap(array, gt--, i);
            } else {
                i++;
            }
        }
        quick3way(array, lo, lt - 1);
        quick3way(array, gt + 1, hi);
        return array;
    }

    public static int[] quickSort(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);

        return quickSort(copy, 0, array.length - 1);
    }

    private static int[] quickSort(int[] array, int lo, int hi) {
        if (lo < hi) {
            return array;
        }
        int j = partition(array, lo, hi);
        quickSort(array, lo, j - 1);
        quickSort(array, j + 1, hi);
        return array;
    }

    public static int partition(int[] array, int lo, int hi) {
        if (lo == hi) {
            return lo;
        }
        int v = array[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (array[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (array[--j] > v) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(array, i, j);
        }
        swap(array, lo, j);
        return j;
    }

    /**
     * 使用位运算的实现方法有 bug，当 i == j 时，会将 array[i] 置为0;
     *
     * @param array 数组
     * @param i     第一个下标
     * @param j     第二个下标
     */
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    @Test
    public void swapTest() {
        int[] array = new int[]{1};
        swap(array, 0, 0);
        assert "[1]".equals(Arrays.toString(array));
    }
}
