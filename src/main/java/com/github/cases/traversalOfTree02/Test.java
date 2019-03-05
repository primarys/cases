package com.github.cases.traversalOfTree02;

import com.github.cases.traversalOfTree02.TreeTraversal.TreeNode;
import com.github.cases.traversalOfTree02.*;
/**
 * @Author: jiang tongxue
 * @Date: 2019/3/5 11:28
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

        //递归
        TreeTraversal treeTraversal = new TreeTraversal();
        treeTraversal.recursionOfFirst(node1);
        System.out.println("");
        treeTraversal.recursionOfMiddle(node1);
        System.out.println("");
        treeTraversal.recursionOfLast(node1);
        System.out.println("");

        //非递归
        treeTraversal.notRecursionOfFirst(node1);
        System.out.println("");
        treeTraversal.notRecursionOfMiddle(node1);
        System.out.println("");
        treeTraversal.notRecursionOfLast(node1);
        System.out.println("");


    }
}
