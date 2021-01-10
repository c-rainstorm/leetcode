package me.rainstorm.ds;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeTraverse {

    public List<Integer> preOrder(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        doPreOrder(root, list);
        return list;
    }

    private void doPreOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            doPreOrder(root.left, list);
            doPreOrder(root.right, list);
        }
    }

    public List<Integer> inOrder(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        doInOrder(root, list);
        return list;
    }

    private void doInOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            doInOrder(root.left, list);
            list.add(root.val);
            doInOrder(root.right, list);
        }
    }


    public List<Integer> postOrder(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        doPostOrder(root, list);
        return list;
    }

    private void doPostOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            doPostOrder(root.left, list);
            doPostOrder(root.right, list);
            list.add(root.val);
        }
    }
}
