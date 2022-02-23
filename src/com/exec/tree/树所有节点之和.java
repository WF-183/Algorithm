package com.exec.tree;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/2/22
 * @version: 1.0.0
 */
public class 树所有节点之和 {

    public static void main(String[] args) {
        //构建测试用的树
        //    3
        // 5     1
        //6  2  0 8
        //  7 4
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        root.left = node5;
        root.right = node1;
        node5.left = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        node5.right = node2;
        node1.left = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        node1.right = node8;
        node2.left = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        node2.right = node4;

        System.out.println(sum(root));

    }



    //递归后序位置 求树中所有节点之和
    public static int sum(TreeNode node){
        if(node == null){
            return 0 ;
        }
        int leftSum = sum(node.left);
        int rightSum = sum(node.right);
        return leftSum + rightSum + node.val;
    }
}
