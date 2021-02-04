package com.getouo.solutions;

import java.util.function.BiFunction;

// 1576. 替换所有的问号 https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
public class Leetcode1576 {

    public static String modifyString(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0, len = chars.length; i < len; i++) {
            if (chars[i] == '?') {
                chars[i] = 'a';
                while ((i > 0 && chars[i - 1] == chars[i]) || (i < len - 1 && chars[i + 1] == chars[i])) {
                    chars[i]++;
                }
            }
        }
        return new String(chars);
    }

}
