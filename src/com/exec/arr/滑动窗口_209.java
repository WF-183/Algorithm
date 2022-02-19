package com.exec.arr;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/2/9
 * @version: 1.0.0
 */
class 滑动窗口_209 {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));
    }



    //209.长度最小的子数组

    //滑动窗口 - 标准写法
    //时间复杂度是$O(n)$。
    //不要以为for里放一个while就以为是$O(n^2)$啊，
    //主要是看每一个元素被操作的次数，每个元素在滑动窗后进来操作一次，出去操作一次，每个元素都是被被操作两次，所以时间复杂度是 2 × n 也就是O(2n) = O(n)
    public static int minSubArrayLen(int target, int[] nums) {
        //滑动窗口法
        int left = 0;
        int sum = 0;
        int count = Integer.MAX_VALUE;

        //外层循环滑动右边界，内层循环滑动左边界
        for (int right = 0; right < nums.length; right++) {//不满足时滑动右边界
            sum += nums[right];

            //满足时滑动左边界直到不满足，再去滑动右边界
            while (sum >= target){
                count = count < (right-left+1) ? count : (right-left+1);

                sum -= nums[left];
                left++;
            }
        }
        return count == Integer.MAX_VALUE ? 0 : count;
    }

    //滑动窗口 - 自己第一版写法
    public static int minSubArrayLen1(int target, int[] nums) {
        //滑动窗口法
        int i = 0;
        int j = 0;
        int sum = 0;
        int count = Integer.MAX_VALUE;

        while(i <= j && j <= nums.length -1){
            sum += nums[j];
            if(sum >= target){
                count = count < (j-i+1) ? count : (j-i+1);

                //每次找到一组后复位右边界，重新跑
                i++;
                j = i;
                sum = 0;
            }else{
                j++;
            }
        }

        return count == Integer.MAX_VALUE ? 0 : count;
    }
}
