package com.exec.tree;

import java.util.logging.Level;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/2/18
 * @version: 1.0.0
 */
public class 左叶子节点之和_404 {

    public static void main(String[] args) {
        //构建测试用的树
        //   0
        // 1   2
        //3 4 5 6
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(1);
        root.right.left.right = new TreeNode(6);
        root.right.right.right = new TreeNode(8);
        System.out.println(sumOfLeftLeaves(root));

    }


    static int sum = 0;
    static boolean flag = false;

    public static int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        preOrderSum(root);
        return sum;
    }


    // 前序遍历-递归
    public static void preOrderSum(TreeNode node){
        if(node.left == null && node.right == null && flag){
            sum += node.val;
        }
        if(node.left != null){
            flag = true;
            preOrderSum(node.left);
            flag = false;
        }
        if(node.right != null){
            flag = false;
            preOrderSum(node.right);
            flag = false;
        }
    }


}

