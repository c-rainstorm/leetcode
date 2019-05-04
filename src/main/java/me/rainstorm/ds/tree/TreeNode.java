package me.rainstorm.ds.tree;

/**
 * @author baochen1.zhang
 * @date 2019.05.02
 */
public class TreeNode<Key extends Comparable<Key>, Value> {
    static final boolean RED = true;
    static final boolean BLACK = false;

    Key key;
    Value value;
    TreeNode<Key, Value> left, right;
    int size;
    int height;
    boolean color;

    public TreeNode(Key key, Value value) {
        this(key, value, 1, 1);
    }

    public TreeNode(Key key, Value value, boolean color) {
        this(key, value, 1, 1, color);
    }

    public TreeNode(Key key, Value value, int height) {
        this(key, value, 1, height);
    }

    public TreeNode(Key key, Value value, int size, int height) {
        this(key, value, size, height, RED);
    }

    public TreeNode(Key key, Value value, int size, int height, boolean color) {
        this.key = key;
        this.value = value;
        this.size = size;
        this.height = height;
        this.color = color;
    }
}
