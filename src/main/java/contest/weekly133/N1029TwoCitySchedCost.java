package contest.weekly133;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author baochen1.zhang
 * @date 2019.04.21
 */
public class N1029TwoCitySchedCost {

    @Test
    public void case1() {
        assert 110 == twoCitySchedCost(new int[][]{
                {10, 20}, {30, 200}, {400, 50}, {30, 20}
        });
    }

    @Test
    public void case2() {
        assert 20269 == twoCitySchedCost(new int[][]{
                {33, 135}, {849, 791}, {422, 469}, {310, 92}, {253, 489}, {995, 760}, {852, 197}, {658, 216},
                {679, 945}, {197, 341}, {362, 648}, {22, 324}, {408, 25}, {505, 734}, {463, 279}, {885, 512},
                {922, 850}, {784, 500}, {557, 860}, {528, 367}, {877, 741}, {554, 545}, {598, 888}, {558, 104},
                {426, 427}, {449, 189}, {113, 51}, {201, 221}, {251, 62}, {981, 897}, {392, 519}, {115, 70}, {961, 109},
                {512, 678}, {476, 708}, {28, 902}, {763, 282}, {787, 774}, {925, 475}, {253, 532}, {100, 502}, {110, 857},
                {822, 942}, {231, 186}, {869, 491}, {651, 344}, {239, 806}, {651, 193}, {830, 360}, {427, 69}, {776, 875},
                {466, 81}, {520, 959}, {798, 775}, {875, 199}, {110, 396}
        });
    }

    public int twoCitySchedCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int[] dis = new int[costs.length];
        int count = 0;
        for (int[] cost : costs) {
            dis[count++] = cost[0] - cost[1];
        }

        Arrays.sort(dis);

        int mid = dis[dis.length / 2 - 1];
        int equalMid = 0;
        for (int i = dis.length / 2 - 1; i > 0; --i) {
            if (dis[i] == mid) {
                equalMid++;
            } else {
                break;
            }
        }
        int aCount = 0;
        int bCount = 0;
        int result = 0;
        int size = dis.length >> 1;
        for (int[] cost : costs) {
            int curCost = cost[0] - cost[1];
            if (aCount < size && curCost <= mid) {
                if (curCost == mid) {
                    if(equalMid > 0){
                        equalMid--;
                        aCount++;
                        result += cost[0];
                        continue;
                    }
                } else {
                    aCount++;
                    result += cost[0];
                }
            }
            if (bCount < size && curCost >= mid) {
                bCount++;
                result += cost[1];
            }
        }
        return result;
    }
}
