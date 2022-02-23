package com.exec.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/2/22
 * @version: 1.0.0
 */
public class 切割IP子串_93 {

    public static void main(String[] args) {
        //输入：s = "25525511135"
        //输出：["255.255.11.135","255.255.111.35"]
        //String s = "25525511135";
        String s = "101023";
        System.out.println(restoreIpAddresses(s));
    }


    // 辅助回溯过程结果收集
    static List<String> res = new ArrayList();
    static List<String> paths = new ArrayList();

    public static List<String> restoreIpAddresses(String s) {
        // 保持左闭右闭
        backTrack(s,0,s.length()-1,1);
        return res;
    }

    //255 255 111 35
    // 需要start、end实现逐位、逐可能长度的切割子串
    // 需要借助deep判断切分四段
    public static void backTrack(String s , int start, int end ,int deep){
        // 递归出口，收集结果
        // 本题明确要求只会分成4段，所以不能用切割线切到最后作为终止条件，而是分割的段数作为终止条件
        if(deep > 4){
            // 判断每个整数位于 0 到 255 之间组成，且不能含有前导 0
            boolean flag = true;
            for(String item : paths){
                flag = flag && judgeOkIp(item);
            }
            if(flag){
                String resItem = "";
                for(int i = 0; i < paths.size()-1;i++){
                    resItem = resItem + paths.get(i) + ".";
                }
                resItem = resItem + paths.get(paths.size()-1);
                res.add(resItem);
            }
            return;
        }

        // 切割过程 aab ，第一段长度分别取1-length，剩下部分也这样分别按1-剩余总length切
        // a ，a/b
        // aa，b/
        // aab，
        for(int i = start ; i < s.length(); i++){
            String str = s.substring(start,i+1);
            if(deep == 4){
                //第四段截取剩下所有部分
                str = s.substring(start,end+1);
                //取消本层后续所有for操作
                i = s.length();
            }
            paths.add(str);

            backTrack(s,i+1,end,deep+1);
            paths.remove(paths.size()-1);
        }

    }


    // 辅助方法 判断一个字符串是不是0-255,且不能含有前导 0
    public static boolean judgeOkIp(String str){
        if(str == null || "".equals(str)){
            return false;
        }
        if(str.length() > 1 && str.charAt(0) == '0'){
            return false;
        }
        if(str.length() > 3){
            return false;
        }
        int num = Integer.parseInt(str);
        if(num > 255 || num < 0){
            return false;
        }
        return true;
    }


}
