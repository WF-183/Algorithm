package com.exec.arr;

import java.util.Arrays;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/4/11
 * @version: 1.0.0
 */
public class 下一个排列_31 {


    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1};
        new 下一个排列_31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }



    // [4,5,2,6,3,1]
    public void nextPermutation(int[] nums) {
        // 两遍扫描
        // 1 先找最靠右的较小数，倒序遍历找，第一个nums[i]<nums[i + 1]，i就是目标元素 且 [i+1,length)之间必然是下降序列
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 2 如果找到了，在区间 [i+1,length)中从后向前查找第一个元素j 满足 a[i] < a[j]，就是要找的尽量小「较大数」
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            // 交换两者 [4,5,2,6,3,1] ==》[4,5,3,6,2,1]
            swap(i,j,nums);
        }
        //3 反转 [4,5,3,6,2,1] ==》 [4,5,3,1,2,6]就是所要结果
        reverse(i + 1, nums.length - 1,nums);

        // 如果在步骤 1 找不到顺序对，说明当前序列已经是一个降序序列，即最大的序列，我们直接跳过步骤 2 执行步骤 3，即可得到最小的升序序列
    }

    // 注：
    // 复杂度分析
    // 时间复杂度：O(N) ，其中 NN 为给定序列的长度。我们至多只需要扫描两次序列，以及进行一次反转操作。
    // 空间复杂度：O(1) ，只需要常数的空间存放若干变量



    //可以直接使用双指针反转指定数组区间 使其变为升序，而无需对该区间进行排序
    public void reverse(int left , int right , int[] nums){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }


    //通用辅助方法 交换
    public void swap(int i , int j , int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }






}
