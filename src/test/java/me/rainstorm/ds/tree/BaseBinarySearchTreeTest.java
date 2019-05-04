package me.rainstorm.ds.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author baochen1.zhang
 * @date 2019.05.02
 */
public abstract class BaseBinarySearchTreeTest<Key extends Comparable<Key>, Value> {
    protected BinarySearchTree<Key, Value> binarySearchTree;
    protected List<Key> keyList = new ArrayList<>(SIZE);
    protected static final int SIZE = 10;

    protected abstract TreeNode<Key, Value> randomNode(int index);

    @Before
    public void createBST() {
        binarySearchTree = createBST(keyList);
    }

    private BinarySearchTree<Key, Value> createBST(List<Key> keyList) {
        BinarySearchTree<Key, Value> binarySearchTree = newBSTInstance();
        while (binarySearchTree.size() < SIZE) {
            TreeNode<Key, Value> keyValue = randomNode(binarySearchTree.size());
            if (binarySearchTree.contains(keyValue.key)) {
                continue;
            }
            keyList.add(keyValue.key);
            binarySearchTree.put(keyValue.key, keyValue.value);
            assert binarySearchTree.isValid();
        }
        return binarySearchTree;
    }

    protected abstract BinarySearchTree<Key, Value> newBSTInstance();

    @Test
    public void put() {
        assert binarySearchTree.size() == SIZE;
    }

    @Test
    public void get() {
        Random random = new Random(System.currentTimeMillis());
        TreeNode<Key, Value> keyValue = randomNode(random.nextInt(binarySearchTree.size()));
        binarySearchTree.put(keyValue.key, keyValue.value);

        assert binarySearchTree.isValid();

        assert keyValue.value.equals(binarySearchTree.get(keyValue.key));
    }

    @Test
    public void min() {
        Collections.sort(keyList);

        assert keyList.get(0).equals(binarySearchTree.min());
    }

    @Test
    public void max() {
        Collections.sort(keyList);

        assert keyList.get(SIZE - 1).equals(binarySearchTree.max());
    }

    @Test
    public void deleteMin() {
        List<Key> list = new ArrayList<>(SIZE);
        BinarySearchTree<Key, Value> binarySearchTree = createBST(list);
        Collections.sort(list);

        int originSize = binarySearchTree.size();
        binarySearchTree.deleteMin();

        assert binarySearchTree.isValid();
        assert originSize == binarySearchTree.size() + 1;
        assert list.get(1).equals(binarySearchTree.min());
    }

    @Test
    public void deleteMax() {
        List<Key> list = new ArrayList<>(SIZE);
        BinarySearchTree<Key, Value> binarySearchTree = createBST(list);
        Collections.sort(list);

        int originSize = binarySearchTree.size();
        binarySearchTree.deleteMax();

        assert binarySearchTree.isValid();
        assert originSize == binarySearchTree.size() + 1;
        assert list.get(SIZE - 2).equals(binarySearchTree.max());
    }

    @Test
    public void delete() {
        List<Key> list = new ArrayList<>(SIZE);
        BinarySearchTree<Key, Value> binarySearchTree = createBST(list);
        Collections.sort(list);

        for (Key key : list) {
            int originSize = binarySearchTree.size();
            binarySearchTree.delete(key);

            assert binarySearchTree.isValid();
            assert originSize == binarySearchTree.size() + 1;
        }
    }
}
