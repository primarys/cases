package com.github.cases.traversalOfTree02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: jiang tongxue
 * @Date: 2019/3/5 10:40
 * @Version 1.0
 */
public class TreeTraversal {

    /**
     * 递归遍历
     */

    //前序
    public void recursionOfFirst(TreeNode root){
        if (root == null)
            return;
        System.out.print(root.value + " ");
        recursionOfFirst(root.left);
        recursionOfFirst(root.right);
    }

    //中序遍历
    public void recursionOfMiddle(TreeNode root){
        if (root == null)
            return;
        recursionOfMiddle(root.left);
        System.out.print(root.value + " ");
        recursionOfMiddle(root.right);
    }

    //后序
    public void recursionOfLast(TreeNode root){
        if (root == null)
            return;
        recursionOfLast(root.left);
        recursionOfLast(root.right);
        System.out.print(root.value + " ");
    }


    /**
     * 非递归遍历
     */

    //先序
    public void notRecursionOfFirst(TreeNode root){
        if (root == null)
            return;
        Stack BTstack = new Stack<TreeNode>();
        Queue order = new LinkedList<Integer>();//存放先序遍历打印的值
        TreeNode cur = root;
        while (cur != null || !BTstack.isEmpty()){
            while(cur != null){
                order.add(cur.value);//1. 打印
                BTstack.push(cur);//2. 入栈
                cur = cur.left;
            }

            while (cur == null && !BTstack.isEmpty()){
                cur = (TreeNode)BTstack.pop();
                cur = cur.right;
            }
        }
        //输出
        order.forEach(p -> System.out.print(p + " "));
    }


    //中序,在前序的基础上换了一行代码，注意看  1. 打印
    public void notRecursionOfMiddle(TreeNode root){
        if (root == null)
            return;
        Stack BTstack = new Stack<TreeNode>();
        Queue order = new LinkedList<Integer>();//存放中序遍历打印的值
        TreeNode cur = root;
        while (cur != null || !BTstack.isEmpty()){
            while(cur != null){

                BTstack.push(cur);//2. 入栈
                cur = cur.left;
            }

            while (cur == null && !BTstack.isEmpty()){
                cur = (TreeNode)BTstack.pop();
                order.add(cur.value);//1. 打印
                cur = cur.right;
            }
        }
        //输出
        order.forEach(p -> System.out.print(p + " "));
    }


    //后序,只需要在中序遍历的基础上判断其右子树是否为空，或者是否已经被访问过即可
    public void notRecursionOfLast(TreeNode root){
        if(root == null){
            return;
        }
        Stack BTstack = new Stack<TreeNode>();
        Queue order = new LinkedList<Integer>();//存放后序遍历打印的值
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null){
            BTstack.push(cur);
            cur = cur.left;
        }
        while (!BTstack.isEmpty()) {
            cur = (TreeNode) BTstack.pop();
            if (cur.right == null || cur.right == pre) {
                order.add(cur.value);
                pre = cur;
            } else {
                BTstack.push(cur);
                cur = cur.right;
                while (cur != null) {
                    BTstack.push(cur);
                    cur = cur.left;
                }
            }
        }
        //输出
        order.forEach(p -> System.out.print(p + " "));
    }



    //节点结构
    static class TreeNode {
        int value;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int value){
            this.value = value;
        }
    }
}
