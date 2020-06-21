package com.leetcode.string;

import org.junit.Test;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class Code20_Parentheses_Valid {

    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack();
        for(int i = 0; i < str.length; i++){
            if(str[i] == '(' || str[i] == '{' || str[i] == '[') stack.push(str[i]);
            else {
                if(stack.isEmpty()) return false;
                else if(str[i] == ')' && stack.pop() != '(') return false;
                else if(str[i] == '}' && stack.pop() != '{') return false;
                else if(str[i] == ']' && stack.pop() != '[') return false;
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test(){
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));

    }
}
