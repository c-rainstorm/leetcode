package me.rainstorm.ds.tree;

/**
 * @author baochen1.zhang
 * @date 2019.05.04
 */
public class RedBlackTreeTest extends IntegerBSTTest {

    private String STR1 = "SEARCHXMPL";
    private String STR2 = "ACEHLMPRSX";

    private String STR = STR2;
//
//    @Override
//    protected TreeNode<String, Long> randomNode(int index) {
//        return new TreeNode<>(String.valueOf(STR.charAt(index)), System.currentTimeMillis());
//    }

    @Override
    protected BinarySearchTree<Integer, Long> newBSTInstance() {
        return new RedBlackTree<>();
    }
}
