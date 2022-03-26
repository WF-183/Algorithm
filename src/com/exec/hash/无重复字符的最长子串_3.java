package com.exec.hash;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/3/27
 * @version: 1.0.0
 */
public class 无重复字符的最长子串_3 {

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring2(str));
    }

    //无重复字符的最长子串长度
    // 滑动窗口法 + hashMap
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap();

        char[] arr = s.toCharArray();
        while (left <= right && right < s.length()) {
            char c = arr[right];
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
            //关键点 这里不能用if，需要while
            while (map.get(c) > 1) {
                map.put(arr[left], map.get(arr[left]) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }



    //无重复字符的最长子串
    // 滑动窗口法 + hashMap , abcabcbb
    public static String lengthOfLongestSubstring2(String s) {
        String res = null;
        int maxLength = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap();

        char[] arr = s.toCharArray();
        while (left <= right && right < s.length()) {
            char c = arr[right];
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
            //关键点 这里不能用if，需要while
            while (map.get(c) > 1) {
                map.put(arr[left], map.get(arr[left]) - 1);
                left++;
            }

            if(right - left + 1 > maxLength){
                res = s.substring(left,right+1);
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return res;
    }

}
