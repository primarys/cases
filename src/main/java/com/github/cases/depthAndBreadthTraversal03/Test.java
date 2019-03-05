package com.github.cases.depthAndBreadthTraversal03;

import com.github.cases.depthAndBreadthTraversal03.DepthAndBreadthTraversal.TreeNode;

/**
 * @Author: jiang tongxue
 * @Date: 2019/3/5 19:56
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;

        DepthAndBreadthTraversal p = new DepthAndBreadthTraversal();
        p.DFSWithRecursive(node1);
        System.out.println();
        p.DFSWithNotRecursive(node1);
        System.out.println();
        p.BFS(node1);

    }

}
