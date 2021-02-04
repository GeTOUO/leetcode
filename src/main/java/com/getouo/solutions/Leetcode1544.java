package com.getouo.solutions;

import java.util.Arrays;

// 1544. 整理字符串 https://leetcode-cn.com/problems/make-the-string-great/
public class Leetcode1544 {

    public static String makeGood(String s) {
        char[] chars = s.toCharArray();
        int re = 0;

        for (int i = 0, iLen = chars.length - 1; i < iLen; i++) {
            if (Math.abs(chars[i] - chars[i + 1]) == 32) { // 如果发现目标对,则用后面的元素覆盖，并减少遍历长度
                re += 2;
                for (int j = i, jLen = (iLen -= 2); j <= jLen; j++) chars[j] = chars[j + 2];
                i = Math.max(-1, i - 2);
            }
        }
        if (re == 0) return s;
        return String.valueOf(Arrays.copyOfRange(chars, 0, chars.length - re));
    }

}
