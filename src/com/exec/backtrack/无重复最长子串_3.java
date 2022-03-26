package com.exec.backtrack;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/2/24
 * @version: 1.0.0
 */
public class 无重复最长子串_3 {



    public static void main(String[] args) {

        System.out.println(new 无重复最长子串_3().lengthOfLongestSubstring("pwwkew"));


        //用回溯法有性能问题，cyoywbmvzhxpenhvivth对应res已经达到五百多万
        //System.out.println(new 无重复最长子串_3().lengthOfLongestSubstring1("cyoywbmvzhxpenhvivth"));
    }

    //解二 滑动窗口法
    // 滑动窗口法 + hashMap
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        Map<Character,Integer> map = new HashMap();


        char[] arr = s.toCharArray();
        while(left <= right && right < s.length()){
            char c =arr[right];
            if(!map.containsKey(c)){
                map.put(c,0);
            }
            map.put(c,map.get(c)+1);
            //关键点 这里不能用if，需要while
            while (map.get(c) > 1){
                map.put(arr[left],map.get(arr[left])-1);
                left++;
            }
            maxLength = Math.max(maxLength,right - left + 1);
            right++;
        }
        return maxLength;
    }



    //解一 回溯法
    List<String> paths = new ArrayList();
    List<String> res = new ArrayList();

    public int lengthOfLongestSubstring1(String s) {
        backTrack(s, 0);


        int max = 0;
        for (String item : this.res) {
            max = Math.max(max, item.length());
        }
        return max;
    }

    //pwwkew
    public void backTrack(String s, int startIndex) {
        if (startIndex == s.length()) {
            //切完，对应一种切割方案
            //挑出子串中无重复元素的子串
            for (String item : paths) {
                if (checkOk(item)) {
                    res.add(item);
                }
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            paths.add(s.substring(startIndex, i + 1));
            backTrack(s, i + 1);
            paths.remove(paths.size() - 1);
        }

    }

    public boolean checkOk(String str) {
        //判断str中是否有重复元素
        char[] arr = str.toCharArray();
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    flag = true;
                }
            }
        }
        return !flag;
    }

}
