package s0200;

import me.rainstorm.ds.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class N0297SerializeAndDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serDFS(root, sb);
        return sb.toString();
    }

    public void serDFS(TreeNode root, StringBuilder str) {
        if (null == root) {
            str.append("N,");
            return;
        }
        str.append(root.val).append(",");
        serDFS(root.left, str);
        serDFS(root.right, str);
    }

    public TreeNode deserialize(String data) {
        Deque<String> nodeList = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserDFS(nodeList);
    }

    public TreeNode deserDFS(Deque<String> nodes) {
        String nodeValue = nodes.pollFirst();
        assert nodeValue != null;
        if ("N".equals(nodeValue)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodeValue));
        node.left = deserDFS(nodes);
        node.right = deserDFS(nodes);
        return node;
    }
}
