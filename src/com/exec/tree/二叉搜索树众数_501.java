package com.exec.tree;

import java.util.*;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/2/21
 * @version: 1.0.0
 */
public class 二叉搜索树众数_501 {
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList();
        // 中序遍历 二叉搜索树转递增list
        midOrder(root,list);

        // 借助map统计各元素出现次数
        Map<Integer,Integer> map = new HashMap();
        for(int item : list){
            if(!map.containsKey(item)){
                map.put(item,0);
            }
            map.put(item,map.get(item)+1);
        }
        List<Integer> coll = new ArrayList<>(map.values());
        // 频率升序，最后一个元素就是最大次数
        Collections.sort(coll);
        int maxCount = coll.get(coll.size() - 1);
        // map遍历
        List<Integer> res = new ArrayList();
        for(int key : map.keySet()){
            if(map.get(key) == maxCount){
                res.add(key);
            }
        }
        int[] arr = new int[res.size()];
        for(int i = 0 ; i < res.size() ; i++){
            arr[i] = res.get(i);
        }
        return arr;
    }



    // 中序遍历 二叉搜索树转递增list
    public void midOrder(TreeNode node,List<Integer> list){
        if(node.left != null){
            midOrder(node.left,list);
        }
        list.add(node.val);
        if(node.right != null){
            midOrder(node.right,list);
        }
    }
}

