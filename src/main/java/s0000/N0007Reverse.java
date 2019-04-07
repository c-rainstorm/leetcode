package s0000;

import org.junit.Test;

/**
 * @author baochen1.zhang
 * @date 2019.04.01
 */
public class N0007Reverse {

    @Test
    public void case1(){
        int result = reverse(321);
        assert result == 123;
    }

    @Test
    public void case2(){
        int result = reverse(-123);
        assert result == -321;
    }

    @Test
    public void case3(){
        int result = reverse(0);
        assert result == 0;
    }

    @Test
    public void case4(){
        int result = reverse(1234567899);
        assert result == 0;
    }

    @Test
    public void case5(){
        int result = reverse(-2147483648);
        assert result == 0;
    }

    @Test
    public void case6(){
        int result = reverse(1563847412);
        assert result == 0;
    }

    public int reverse(int x) {
        int result = 0;
        int sign = Integer.signum(x);
        long source = (long) sign * x;
        while(source != 0){
            // tmp 不可能为负数
            long tmp = result * 10L + source % 10;
            if(tmp >> 31 > 0){
                return 0;
            }

            result = (int)tmp;
            source /= 10;
        }
        return result * sign;
    }
}
