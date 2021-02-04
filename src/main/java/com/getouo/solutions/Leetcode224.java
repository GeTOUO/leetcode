package com.getouo.solutions;

// 224. 基本计算器 https://leetcode-cn.com/problems/basic-calculator/
public class Leetcode224 {

    private int nextBracketsValue = 0;
    private int skipToIndex = 0;

    public int calculate(String s) {
        calculate(s.toCharArray(), 0);
        return nextBracketsValue;
    }

    public void calculate(char[] chars, int index) {
        int currentValue = 0;
        boolean isAddition = true;
        int numCache = 0;

        for (int i = index; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar != ' ') {
                if ('0' <= aChar && aChar <= '9') {
                    int num = aChar - '0';
                    numCache = numCache == 0 ? num : numCache * 10 + num;
                } else {
                    if (numCache != 0) {
                        if (isAddition) {
                            currentValue = currentValue + numCache;
                            numCache = 0;
                        } else {
                            currentValue = currentValue - numCache;
                            numCache = 0;
                        }
                    }
                    if (aChar == '(') {
                        calculate(chars, i + 1);
                        i = skipToIndex;
                        numCache = nextBracketsValue;
                    } else if (aChar == '+' || aChar == '-') {
                        isAddition = aChar == '+';
                    } else if (aChar == ')') {
                        nextBracketsValue = currentValue;
                        skipToIndex = i;
                        return;
                    }
                }
            }

            if (i + 1 == chars.length && numCache != 0) {
                nextBracketsValue = isAddition ? currentValue + numCache : currentValue - numCache;
                return;
            }
        }
        nextBracketsValue = currentValue;
    }

}
