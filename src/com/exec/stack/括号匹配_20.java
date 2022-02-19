package com.exec.stack;

import java.util.Deque;
import java.util.Stack;

/**
 *
 * @author： <a href="mailto:wangfei@tianyancha.com">wangfei</a>
 * @date: 2022/2/15
 * @version: 1.0.0
 */
public class 括号匹配_20 {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    // 它要得这个顺序对应类似于我们写代码是一对对括号的关系，对称操作想到栈
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        char[] arr = s.toCharArray();
        for(char item : arr){
            // 技巧点 进来左括号时存对应右括号
            if(item == '('){
                stack.push(')');
            }else if(item == '{'){
                stack.push('}');
            }else if(item == '['){
                stack.push(']');
            }else{//不是前三个分支，那就肯定是一个右括号进来了
                // 1、如果左括号总数比右括号少
                if(stack.isEmpty()){
                    return false;
                }
                // 2、如果顺序不对应
                char pop = stack.pop();
                if(pop != item){
                    return false;
                }
            }
        }
        // 3、如果右括号总数比左括号少，则栈会不空
        // 如果能顺利走到这，且栈刚好空，则就是符合要求的
        return stack.isEmpty();
    }

}
