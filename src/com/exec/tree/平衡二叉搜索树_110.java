package com.exec.tree;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/2/18
 * @version: 1.0.0
 */
public class 平衡二叉搜索树_110 {

    public static void main(String[] args) {
        //构建测试用的树
        //   3
        // 9   20
        //    15 7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(isBalanced(root));

    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        int leftMax = maxHeight(root.left);
        int rightMax = maxHeight(root.right);
        if(Math.abs(leftMax - rightMax) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }


    // 求指定节点为根节点的树最大高度
    public static int maxHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftMax = maxHeight(node.left);
        int rightMax = maxHeight(node.right);
        return Math.max(leftMax, rightMax) + 1;
    }
}
