package com.exec.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/2/23
 * @version: 1.0.0
 */
public class 全排列二_47 {

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,1,2}));

    }

    static List<List<Integer>> res = new ArrayList();
    static List<Integer> paths = new ArrayList();

    // 记录一组解中已经使用过的下标 排列题就是要保证同一个下标不能多次使用
    static List<Integer> indexPaths = new ArrayList();


    public static List<List<Integer>> permuteUnique(int[] nums) {
        //有重复元素，先排序，让重复元素挨着，简化递归中处理
        Arrays.sort(nums);
        backTrack(nums);
        return res;
    }

    public static void backTrack(int[] nums) {
        // 终止条件 入选条件，用元素个数 深度
        if (paths.size() == nums.length) {
            res.add(new ArrayList(paths));
            return;
        }

        // 排列 每一层都可能选任意元素，所以必须for(0 - length-1)  , [第一层，第二层，第三层]
        for (int i = 0; i < nums.length; i++) {
            //关键点 排列题就是要保证一组解中同一个下标元素不能多次使用
            //本题元素有重复，不能再用paths，需要借助indexPaths判断下标不取重复，同一元素重复选取跳过当前元素
            if (indexPaths.contains(i)) {
                continue;
            }
            //同层去重 但是不能误伤，当前和上一个元素虽然值相等，但是上一个元素被上一层取了这种情况要放行
            //当前和上一个元素虽然值相等 且 上一个元素没被上一层取，才跳过当前元素
            if (i > 0 && nums[i] == nums[i - 1] && !indexPaths.contains(i - 1)) {
                continue;
            }
            paths.add(nums[i]);
            indexPaths.add(i);
            backTrack(nums);
            paths.remove(paths.size() - 1);
            indexPaths.remove(indexPaths.size() - 1);
        }
    }

}
