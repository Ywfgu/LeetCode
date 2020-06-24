package com.leetcode.backtracking;

import org.apache.logging.log4j.util.Chars;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。

 示例:
 输入: S = "a1b2"
 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]

 输入: S = "3z4"
 输出: ["3z4", "3Z4"]

 输入: S = "12345"
 输出: ["12345"]

 */
public class Code784_LetterCasePermutation {
    /**
     * 迭代
     */
    public List<String> letterCasePermutation(String S) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());

        for (char c : S.toCharArray()){
            if(Character.isLetter(c)){
                int n = ans.size();
                for (int i = 0; i < n; i++) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n+i).append(Character.toUpperCase(c));
                }
            }else{
                for (int i = 0; i < ans.size(); i++) {
                    ans.get(i).append(c);
                }
            }
        }

        List<String> res = new ArrayList<>();
        for (StringBuilder sb : ans){
            res.add(sb.toString());
        }
        return res;
    }

    /**
     * DFS
     */
    List<String> list;
    public List<String> letterCasePermutation2(String S) {
        list = new ArrayList<>();
        recurse(S.toCharArray(), 0);
        return list;
    }
    public void recurse(char[] chars, int idx){
        if(idx == chars.length){
            list.add(new String(chars));
            return;
        }
        recurse(chars, idx + 1);
        if(chars[idx] >= 'A'){
            chars[idx] = chars[idx] < 'a'? (char)(chars[idx] + 32): (char)(chars[idx] - 32);
            recurse(chars, idx + 1);
        }
    }


    @Test
    public void test(){
        System.out.println(Arrays.toString(letterCasePermutation("a1b2").toArray()));
        System.out.println(Arrays.toString(letterCasePermutation2("a1b2").toArray()));

    }
}
