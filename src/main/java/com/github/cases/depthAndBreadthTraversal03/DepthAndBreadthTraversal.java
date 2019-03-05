package com.github.cases.depthAndBreadthTraversal03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: jiang tongxue
 * @Date: 2019/3/5 19:06
 * @Version 1.0
 */
public class DepthAndBreadthTraversal {


    //BFS 广度优先遍历
    public ArrayList<Integer> BFS(TreeNode root) {
        ArrayList<Integer> lists = new ArrayList<Integer>();
        if (root == null)
            return lists;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tree = queue.poll();
            if (tree.left != null)
                queue.offer(tree.left);
            if (tree.right != null)
                queue.offer(tree.right);
            lists.add(tree.val);
        }
        lists.forEach(p -> System.out.print(p + " "));
        return lists;
    }



    /**
     * 深度优先搜索
     * @param root
     * @return
     */

    //DFS，采用递归的方法
    public void DFSWithRecursive(TreeNode root)
    {
        if (root == null)
            return;
        System.out.print(root.val+" ");
        DFSWithRecursive(root.left);
        DFSWithRecursive(root.right);
    }


    //非递归
    public ArrayList<Integer> DFSWithNotRecursive(TreeNode root) {
        ArrayList<Integer> lists = new ArrayList<Integer>();
        if (root == null)
            return lists;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tree = stack.pop();
            //先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了。
            if (tree.right != null)
                stack.push(tree.right);
            if (tree.left != null)
                stack.push(tree.left);
            lists.add(tree.val);
        }
        lists.forEach(p -> System.out.print(p + " "));
        return lists;
    }




    static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
