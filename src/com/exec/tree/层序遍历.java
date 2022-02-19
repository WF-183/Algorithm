package com.exec.tree;

import java.util.*;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/2/16
 * @version: 1.0.0
 */
public class 层序遍历 {

    public static void main(String[] args) {
        //构建测试用的树
        //   0
        // 1   2
        //3 4 5 6
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        order(root);

        System.out.println(levelOrder(root));

    }

    //借助队列+while实现树的一层层遍历
    public static void order(TreeNode root) {
        //技能点 所有树的题，上来先写一个根节点判空
        if(root == null){
            return;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);

        //6 5 4 3 2 1 0
        //外层循环 从上到下
        while (deque.size() != 0) {
            //内存循环从左到右
            //坑 必须先取size到辅助变量，因为循环体中改变了size
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pollFirst();
                System.out.println(treeNode.val);
                if (treeNode.left != null) {
                    deque.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.addLast(treeNode.right);
                }
            }
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        //技能点 所有树的题，上来先写一个根节点判空
        if(root == null){
            return res;
        }
        //关于队列我就记忆Deque的相关api就够用了
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);

        //外层循环 从上到下
        while (deque.size() != 0) {
            List<Integer> list = new ArrayList();
            //内存循环从左到右
            //坑 必须先取size到辅助变量，因为循环体中改变了size
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                list.add(node.val);
                //非空才入队列
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }

}
