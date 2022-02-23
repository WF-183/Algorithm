package com.exec.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/2/21
 * @version: 1.0.0
 */
public class 二叉树最近公共祖先_236 {


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

        System.out.println(lowestCommonAncestor(root,node2,node8).val);

    }



    static TreeNode res;
    static List<TreeNode> paths = new ArrayList();
    static List<TreeNode> pRes = new ArrayList();
    static List<TreeNode> qRes = new ArrayList();

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        preOrderHuiSu(root,paths,p,pRes);
        paths.clear();
        preOrderHuiSu(root,paths,q,qRes);

        for(int i = 0 ; i < pRes.size(); i++){
            for(int j = 0 ; j < qRes.size(); j++){
                if(pRes.get(i) == qRes.get(j)){
                    res =  pRes.get(i);
                }
            }
        }
        return res;
    }

    // 回溯
    public static void preOrderHuiSu(TreeNode node,List<TreeNode> paths,TreeNode endNode,List<TreeNode> partRes){
        paths.add(node);
        if(node == endNode){
            partRes.addAll(new ArrayList(paths));
            return;
        }
        if(node.left != null){
            preOrderHuiSu(node.left,paths,endNode,partRes);
            paths.remove(paths.size()-1);
        }
        if(node.right != null){
            preOrderHuiSu(node.right,paths,endNode,partRes);
            paths.remove(paths.size()-1);
        }
    }


}
