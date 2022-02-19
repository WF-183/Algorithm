package com.exec.hash;

import java.util.*;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/1/19
 * @version: 1.0.0
 */
public class 两数之和_1 {//梦开始的地方 第一题 两数之和


    //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

    /**
     解法二 哈希表、hashmap 正解
     */
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            if( map.containsKey(nums[i])){
                res[0] = map.get(nums[i]);
                res[1] = i;
                break;
            }
            map.put(target - nums[i],i);
        }
        return res;
    }


    /**
     解法一 暴力破解 ，双层for循环，for+if即可
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }

}

