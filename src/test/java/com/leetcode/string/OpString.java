package com.leetcode.string;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class OpString {


    public boolean isUnique(String astr) {
        Map map = new HashMap();

        for(int i=0; i< astr.length(); i++) {
            if (map.containsKey(astr.charAt(i))) {
                return false;
            }else {
                map.put(astr.charAt(i),"");
            }
        }
        return true;
    }

    @Test
    public void testisUnique(){
        System.out.println( isUnique("leetcode"));
    }

    /**
     * 对于嵌套有深度的逻辑，使用栈结构，结合需要出栈和入栈的边界条件判断
     * @param s
     * @return
     */
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder mulitstr = new StringBuilder();
        int mulit = 0;
        Stack<Integer> stack_mulit = new Stack();
        Stack<String> stack_char = new Stack();

        for ( char c: s.toCharArray()) {
            if(c == '['){
                mulit = Integer.valueOf(mulitstr.toString());
                stack_mulit.push(mulit);
                stack_char.push(sb.toString());
                mulit = 0;
                sb = new StringBuilder();
                mulitstr = new StringBuilder();
            }else if(c == ']'){
                // 出栈，拼接
                StringBuilder temp = new StringBuilder();
                int len = stack_mulit.pop();
                for (int i = 0; i < len; i++) {
                    temp.append(sb);
                }
                sb = new StringBuilder();
                sb.append(stack_char.pop());
                sb.append(temp);
                
            }else if(Character.isDigit(c)){
                mulitstr.append(c);

            }else if(Character.isLetter(c)){
                sb.append(c);
            }
        }

        return sb.toString();
    }
    @Test
    public void testdecodeString(){
        System.out.println(decodeString("100[leetcode]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }

    @Test
    public void testreverseWords(){
        String s ="Let's take LeetCode contest";

        StringBuilder sb = new StringBuilder();
        String[] s1 = s.split(" ");

        for (String str: s1) {

            int start = 0;
            int end = str.length()-1;
            while (end >= start){
                sb.append(str.charAt(end));
                end --;
            }
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    @Test
    public void testreverseStr(){
        String s = "a";
        int k = 1;

        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int len = chars.length;

        int start;
        int end;
        for (int i = 1; i <= len; i++) {
            end = 2*i*k;
            start = 2*k*(i-1);
            if( end <= len){
                sb.append(appendStr(chars,start,start+k-1,true));
                sb.append(appendStr(chars,start+k,end-1,false));
            }else if(end <= len+(2*k)){
                if(start + k > len ){
                    //全反转
                    sb.append(appendStr(chars,start,len-1,true));
                }else {
                    //反转部分
                    sb.append(appendStr(chars,start,start+k-1,true));
                    sb.append(appendStr(chars,start+k,len-1,false));
                }
            }
        }
        System.out.println(sb.toString());
    }

    private String appendStr(char[] chars, int start, int end, boolean b) {
        StringBuilder sb = new StringBuilder();
        if(!b){
            while (start <= end){
                sb.append(chars[start]);
                start++;
            }
        }else {
            while (start <= end){
                sb.append(chars[end]);
                end--;
            }
        }

        return sb.toString();
    }
}
