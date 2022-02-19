package com.exec.tree;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/2/18
 * @version: 1.0.0
 */
public class 构建最大二叉树_654 {

    public static void main(String[] args) {

        TreeNode treeNode = constructMaximumBinaryTree(new int[] {3, 2, 1, 6, 0, 5});
        System.out.println(111);
    }



    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = build(nums,0,nums.length-1);
        return root;
    }


    public static TreeNode build(int[] nums,int left,int right){
        if(left > right){
            return null;
        }
        // 求极值
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        // 左闭右闭
        for(int i = left ; i <= right ; i++){
            if(nums[i] > max){
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = build(nums,left,maxIndex-1);
        root.right = build(nums,maxIndex+1,right);
        return root;
    }



}
