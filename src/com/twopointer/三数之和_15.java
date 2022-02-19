package com.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/2/16
 * @version: 1.0.0
 */
public class 三数之和_15 {


    public static void main(String[] args) {

        System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    }


    //三数之和比两数之和麻烦多了 双指针法
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if(nums.length < 3){
            return res;
        }
        // 得先排序 -4 -1 -1 0 1 2
        Arrays.sort(nums);


        for(int i = 0 ; i < nums.length; i++){
            int left = i+1;
            int right = nums.length - 1;

            //因为不要重复元素解，所以多一步处理。始终记得数组已经排完序了，相同值都是挨着的。
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while(right > left){
                if(nums[i] + nums[left] + nums[right] > 0){//偏大了
                    right--;
                }else if(nums[i] + nums[left] + nums[right] < 0){//偏小了
                    left++;
                }else{//找到一组解
                    res.add(Arrays.asList(nums[i] , nums[left] , nums[right]));

                    //因为不要重复元素解，所以多一步处理。始终记得数组已经排完序了，相同值都是挨着的。
                    while (right > left && nums[right] == nums[right-1]){
                        right--;
                    }
                    while (right > left && nums[left] == nums[left+1]){
                        left++;
                    }

                    //收缩范围 必须否则死循环
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
