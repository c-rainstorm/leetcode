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
    int height;

    public TreeNode(Key key, Value value) {
        this(key, value, 1, 1);
    }

    public TreeNode(Key key, Value value, int height) {
        this(key, value, 1, height);
    }


    public TreeNode(Key key, Value value, int size, int height) {
        this.key = key;
        this.value = value;
        this.size = size;
        this.height = height;
    }
}
