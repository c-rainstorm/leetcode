package me.rainstorm.ds.tree;

import java.util.Random;

/**
 * @author baochen1.zhang
 * @date 2019.05.02
 */
public class IntegerBSTTest extends BaseBinarySearchTreeTest<Integer, Long> {

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    @Override
    protected TreeNode<Integer, Long> randomNode() {
        return new TreeNode<>(RANDOM.nextInt(100), System.currentTimeMillis());
    }
}
