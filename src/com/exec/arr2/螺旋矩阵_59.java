package com.exec.arr2;

import java.util.Arrays;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/2/9
 * @version: 1.0.0
 */
public class 螺旋矩阵_59 {

    public static void main(String[] args) {
        generateMatrix(4);
    }


    public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];

        int left = 0;
        int right = n-1;
        int up = 0;
        int down = n-1;

        int num = 1;

        while(num <= n * n){
            //上边界 从左到右
            if(up <= down){
                for(int j = left ; j <= right ; j++){
                    arr[up][j] = num++;
                }
                //收紧边界
                up++;
            }
            //右边界 从上到下
            if(left <= right){
                for(int i = up ; i <= down ; i++){
                    arr[i][right] = num++;
                }
                //收紧边界
                right--;
            }
            //下边界 从右到左
            if(up <= down){
                for(int j = right ; j >= left ; j--){
                    arr[down][j] = num++;
                }
                //收紧边界
                down--;
            }
            //左边界 从下到上
            if(left <= right){
                for(int i = down ; i >= up ; i--){
                    arr[i][left] = num++;
                }
                //收紧边界
                left++;
            }
        }
        return arr;
    }

}
