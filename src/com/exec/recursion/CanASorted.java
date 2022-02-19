package com.exec.recursion;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/1/26
 * @version: 1.0.0
 */
public class CanASorted {

    //两个数组A、B，长度都是N，A[i] 、B[i]可以选择交换，也可以不交换，你的目的是让A有序 比如升序，返回你能不能做到
    public static void main(String[] args) {
        //int[] A = new int[]{3, 2, 1, 5 ,6};
        //int[] B = new int[]{0 ,6, 4 ,3, 1};
        //System.out.println(canASorted(A,B));

        int[] A = new int[] {3, 7, 1, 5, 6};
        int[] B = new int[] {0, 8, 4, 3, 1};
        System.out.println(canASorted(A, B));
    }

    public static boolean canASorted(int[] A, int[] B) {
        return process(A, B, 0, -1);
    }

    /**憋一个递归
     * @param A
     * @param B
     * @param index 遍历游标，A当前位置
     * @param pre A前一个位置上的最终选定的元素值
     * @return index之前的部分是否都能被处理的有序 这里假定升序
     */
    public static boolean process(int[] A, int[] B, int index, int pre) {
        //这个方法功能是index之前的部分是否都能被处理的有序，index能走完，则整个数组就有序了
        if (index >= A.length) {
            return true;
        }
        //两种情况枚举，取并集
        //A-index位置元素和B换，
        boolean b1 = B[index] > pre ? process(A, B, index + 1, B[index]) : false;
        //A-index位置元素不和B换
        boolean b2 = A[index] > pre ? process(A, B, index + 1, A[index]) : false;
        return b1 || b2;
    }

}
