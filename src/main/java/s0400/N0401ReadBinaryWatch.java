package s0400;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * [401] 二进制手表
 * <p>
 * https://leetcode-cn.com/problems/binary-watch/description/
 * <p>
 * algorithms
 * Easy (45.44%)
 * Total Accepted:    3K
 * Total Submissions: 6.6K
 * Testcase Example:  '0'
 * <p>
 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 * <p>
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * <p>
 * <p>
 * <p>
 * 例如，上面的二进制手表读取 “3:25”。
 * <p>
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 * <p>
 * 案例:
 * <p>
 * <p>
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16",
 * "0:32"]
 * <p>
 * <p>
 * <p>
 * 注意事项:
 * <p>
 * <p>
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 *
 * @author baochen1.zhang
 * @date 2019.04.11
 */
public class N0401ReadBinaryWatch {

    @Test
    public void case1() {
        assert "[]".equals(readBinaryWatch(-1).toString());
    }

    @Test
    public void case2() {
        System.out.println(readBinaryWatch(1).toString());
    }

    public List<String> readBinaryWatch(int num) {
        if (num < 0 || num > 10) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>(50);
        HashMap<Integer, List<Integer>> hourMap = buildMap(12);
        HashMap<Integer, List<Integer>> minMap = buildMap(60);

        for (int i = 0; i <= num; ++i) {
            List<Integer> hours = hourMap.get(i);
            if (hours == null || hours.size() == 0) {
                continue;
            }
            List<Integer> mins = minMap.get(num - i);
            if (mins == null || mins.size() == 0) {
                continue;
            }
            for (Integer hour : hours) {
                for (Integer min : mins) {
                    result.add(String.format("%d:%02d", hour, min));
                }
            }
        }

        return result;
    }

    private HashMap<Integer, List<Integer>> buildMap(int board) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < board; ++i) {
            int bitCount = Integer.bitCount(i);
            map.computeIfAbsent(bitCount, k -> new ArrayList<>());
            List<Integer> list = map.get(bitCount);
            list.add(i);
        }
        return map;
    }
}
