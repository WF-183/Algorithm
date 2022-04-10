package com.exec.sort;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/2/27
 * @version: 1.0.0
 */
public class 快排_912 {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //queue.add(1);//加入一个元素，offer等效于add ，
        //queue.add(2);
        //Integer minEle = queue.poll();//获取堆顶最小元素，并移出队列，remove等效于poll
        //Integer minEle2 = queue.peek();//看一眼堆顶元素，不移出队列

        int[] nums = new int[]{5,2,3,1};
        quickSort(nums,0,nums.length - 1);
        System.out.println(Arrays.toString(nums));

        //Stack stack = new Stack();
        //int size = stack.size();
        //
        //String str = "";
        //char c = str.charAt(1);
        //
        //Map<Integer,Integer> cache = new LinkedHashMap();

    }



    // 手写快排
    //quickSort(nums , 0 , nums.length - 1);
    public static void quickSort(int[] nums, int left , int right){
        // 递归出口
        if(nums == null || nums.length == 0 || left >= right){
            return;
        }

        // 左边界做基准点
        int baseVal = nums[left];
        int cursorL = left;
        int cursorR = right;

        while(cursorL != cursorR){
            // 先右后左，找到一对对该换的交换
            while(nums[cursorR] >= baseVal && cursorL < cursorR){
                cursorR--;
            }
            while(nums[cursorL] <= baseVal && cursorL < cursorR){
                cursorL++;
            }
            // 交换
            int temp = nums[cursorL];
            nums[cursorL] = nums[cursorR];
            nums[cursorR] = temp;
        }

        // 交换基准点 ，cursorL=cursorR，左右游标相遇，结束循环
        nums[left] = nums[cursorL];
        nums[cursorL] = baseVal ;

        // 两边分段进递归
        quickSort(nums,left,cursorL-1);
        quickSort(nums,cursorL+1,right);
    }

}
