package me.rainstorm.ds.tree;

import java.util.Random;

/**
 * @author baochen1.zhang
 * @date 2019.05.02
 */
public class IntegerBSTTest extends BaseBinarySearchTreeTest<Integer, Long> {

    private static final Random RANDOM = new Random(System.currentTimeMillis());
    private static final int BOUND = SIZE * 10;

    @Override
    protected BinarySearchTree<Integer, Long> newBSTInstance() {
        return new BinarySearchTree<>();
    }

    @Override
    protected TreeNode<Integer, Long> randomNode(int index) {
        return new TreeNode<>(RANDOM.nextInt(BOUND), System.currentTimeMillis());
    }
}
