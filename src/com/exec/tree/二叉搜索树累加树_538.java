package com.exec.tree;

import java.util.*;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/2/22
 * @version: 1.0.0
 */
public class 二叉搜索树累加树_538 {

    public static void main(String[] args) {
        ArrayList<Integer> paths = new ArrayList<>();
        paths.add(1);
        paths.add(2);
        int sum = paths.stream().mapToInt(item -> item).sum();
        System.out.println(sum);

        StringBuilder sb = new StringBuilder();
        sb.append("");
        String str = sb.substring(0, sb.length() - 1);
        String str2 = sb.toString();
        sb = sb.deleteCharAt(sb.length()-1);
        Integer integer = new Integer(1);
        int i = Integer.parseInt(str);


        //构建测试用的树
        //    4
        // 1     6
        //0  2  5 7
        //    3     8
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);

        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        convertBST(root);


    }

    public static TreeNode convertBST(TreeNode root) {
        List<TreeNode> paths = new ArrayList();
        preOrderHuiSU(root,paths);
        return root;
    }



    public  static void preOrderHuiSU(TreeNode node,List<TreeNode> paths){
        // 前序遍历-递归 根左右
        paths.add(node);

        // 处理每一个节点
        if(paths.size() == 0){
            node.val = node.val +  sum(node.right) ;
        }else{
            TreeNode parent = paths.get(paths.size() -1);
            node.val = node.val + parent.val + sum(node.right) + sum(parent.right);
        }

        // 非空才进递归
        if(node.left != null){
            preOrderHuiSU(node.left,paths);
            // 回溯 出递归移除上一个访问节点，这个操作必须借助一个额外的list，且跟着入参
            paths.remove(paths.size()-1);
        }
        if(node.right != null){
            preOrderHuiSU(node.right,paths);
            // 回溯 出递归移除上一个访问节点，这个操作必须借助一个额外的list，且跟着入参
            paths.remove(paths.size()-1);
        }
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
