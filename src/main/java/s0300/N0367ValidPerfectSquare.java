package s0300;

/**
 * @author traceless
 */
public class N0367ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long lo = 1, hi = num;
        while (lo <= hi) {
            long mid = (lo + hi) >> 1;
            long tmp = mid * mid;
            if (tmp == num) {
                return true;
            } else if (tmp < num) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
}
