package com.exec.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/2/23
 * @version: 1.0.0
 */
public class N皇后_51 {

    public static void main(String[] args) {
        System.out.println(new N皇后_51().solveNQueens(4));
    }

    List<List<Integer>> res = new ArrayList();
    List<List<String>> resString = new ArrayList();

    // 前提条件 每个皇后必定处在不同行上，用一行行表示一层层深度，约定paths一个下标对应一行，paths元素值对应每一列
    List<Integer> paths = new ArrayList();

    public List<List<String>> solveNQueens(int n) {
        backTrack(n);

        //java手法处理 转换题目所要的输出格式 不是重点
        for (int i = 0; i < res.size(); i++) {
            List<Integer> list = res.get(i);
            List<String> listString = new ArrayList();
            for (int j = 0; j < list.size(); j++) {
                int colIndex = list.get(j);
                String str = "";
                for (int t = 0; t < n; t++) {
                    str = str + ".";
                }
                str = str.substring(0, colIndex) + "Q" + str.substring(colIndex + 1, str.length());
                listString.add(str);
            }
            resString.add(listString);
        }
        return resString;
    }

    public void backTrack(int n) {
        // 终止条件 入选条件 皇后找够了就停
        if (paths.size() == n) {
            //满足入选，不满足舍弃，但都要结束 return;
            if (checkOk(paths)) {
                res.add(new ArrayList(paths));
            }
            return;
        }

        //每一层for对应一层的每一列 ，列数对应0 - length-1
        for (int i = 0; i < n; i++) {
            //优化，不加结果也对 前面用过的列肯定不能再用了
            if (paths.contains(i)) {
                continue;
            }
            //优化，不加结果也对 现有皇后已经冲突，往后的每一层肯定都不用再试了
            if (!checkOk(paths)) {
                //return break都行
                return;
            }
            paths.add(i);
            //每一个递归对应一层深度，对应皇后1-皇后n
            backTrack(n);
            paths.remove(paths.size() - 1);
        }
    }

    // 这个方法也挺关键
    // 辅助方法 判断当前是不是一组满足要求的解
    public boolean checkOk(List<Integer> paths) {
        // 国际象棋规则：两个皇后在同一行或同一列或同一斜线，则可以攻击。
        boolean flag = true;
        //零、一个元素时直接返回不冲突，走下面逻辑会得到错误结论
        if (paths.size() <= 1) {
            return flag;
        }
        // 同一行 paths下标代表行，不可能在同一行

        // 同一列 比较有没有重复元素值
        // 技能点 如何判断一个数组中有没有重复元素，每个元素与其他元素两两比较，坑 注意避开自己
        for (int i = 0; i < paths.size(); i++) {
            for (int j = 0; j < paths.size(); j++) {
                if (i != j && paths.get(i).equals(paths.get(j))) {
                    flag = false;
                }
            }
        }

        // 同一斜线
        // 技能点 如何判断两个点处于同一斜线，斜率相等，坑 注意避开自己
        for (int i = 0; i < paths.size(); i++) {
            for (int j = 0; j < paths.size(); j++) {
                if (i != j && Math.abs(i - j) == Math.abs(paths.get(i) - paths.get(j))) {
                    flag = false;
                }
            }
        }
        return flag;
    }

}
