package com.exec.stack;

import java.util.Stack;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/4/14
 * @version: 1.0.0
 */
public class 多字符消消乐 {

    public static void main(String[] args) {
        System.out.println(new 多字符消消乐().remove("8881616"));
    }

    //8881616
    public String remove(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char item : arr) {
            if (stack.size() >= 2) {
                Character top1 = stack.pop();
                Character top2 = stack.pop();
                if ("816".equals("" + top2 + top1 + item)) {
                    continue;
                } else {
                    stack.push(top2);
                    stack.push(top1);
                }
            }
            stack.push(item);
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }

}
