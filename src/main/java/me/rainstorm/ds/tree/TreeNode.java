package me.rainstorm.ds.tree;

/**
 * @author baochen1.zhang
 * @date 2019.05.02
 */
public class TreeNode<Key extends Comparable<Key>, Value> {
    Key key;
    Value value;
    TreeNode<Key, Value> left, right;
    int size;

    public TreeNode(Key key, Value value) {
        this.key = key;
        this.value = value;
        size = 1;
    }
}
