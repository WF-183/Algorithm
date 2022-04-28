package com.exec.str;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/4/28
 * @version: 1.0.0
 */
public class Score {

    /**
     * // 合并文理成绩表
     * // 1. 文科生成绩表
     * // 语文	数学	英语	政治
     * // 132	143	110	87
     * // ...
     * // 2. 理科生成绩表
     * // 数学	英语	化学	物理
     * //  134	111	87	98
     * // ....
     *
     * // 语文	数学	英语	政治	化学	物理
     * // 132	143	110	87	0	0
     * // 0	134	111	0	87	98
     * // ...
     *
     *
     * // 输入：
     * // ["语文	数学	英语	政治", "132	134	110	87", ...]
     * // ["数学	英语	化学	物理", "   134	111	87	98", ...]
     * // 输出：
     * // ["语文	数学	英语	政治	化学	物理",
     * // "132	134	110	87	0	0",
     * // "0	134	111	0	87	98",
     * // ...]
     *
     *
     * // 列和列之间由\t分割成绩,成绩两侧可能有空格
     * // 可能存在空行和包含制表符的空行,
     * // 其中科目的内容和数量都是可变的。
     */
    public static void main(String[] args) {
        String[] arr1 = new String[] {"语文	数学	英语	政治", "132	134	110	87"};
        String[] arr2 = new String[] {"数学	英语	化学	物理", "   134	111	87	98"};
        System.out.println(Arrays.toString(new Score().mergeArr(arr1, arr2)));
    }

    public String[] mergeArr(String[]... arr) {
        int stdNum = arr.length;
        String[] result = new String[stdNum + 1];
        //TODO 列头需要做成动态的，假设输入{"地理	数学	英语	政治","132	134	110	87"}
        result[0] = "语文 数学  英语  政治  化学  物理";
        int i = 1;
        for (String[] item : arr) {
            result[i++] = merge(item);
        }
        return result;
    }

    public String merge(String[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        String stdClass = arr[0];
        String stdScore = arr[1];
        String[] classSplit = stdClass.trim().split("\\s+");
        String[] scoreSplit = stdScore.trim().split("\\s+");
        //输入映射关系
        Map<String, String> classScoreMap = new HashMap<>();
        for (int i = 0; i < classSplit.length; i++) {
            classScoreMap.put(classSplit[i], scoreSplit[i]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((classScoreMap.get("语文") != null ? classScoreMap.get("语文") : 0) + " ");
        stringBuilder.append((classScoreMap.get("数学") != null ? classScoreMap.get("数学") : 0) + " ");
        stringBuilder.append((classScoreMap.get("英语") != null ? classScoreMap.get("英语") : 0) + " ");
        stringBuilder.append((classScoreMap.get("政治") != null ? classScoreMap.get("政治") : 0) + " ");
        stringBuilder.append((classScoreMap.get("化学") != null ? classScoreMap.get("化学") : 0) + " ");
        stringBuilder.append((classScoreMap.get("物理") != null ? classScoreMap.get("物理") : 0));
        return stringBuilder.toString();
    }

}
