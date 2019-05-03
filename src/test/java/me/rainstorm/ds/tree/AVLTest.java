package me.rainstorm.ds.tree;

/**
 * @author baochen1.zhang
 * @date 2019.05.03
 */
public class AVLTest extends IntegerBSTTest {

    @Override
    protected BinarySearchTree<Integer, Long> newBSTInstance() {
        return new AVLTree<>();
    }
}
