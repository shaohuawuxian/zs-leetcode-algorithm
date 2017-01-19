
package com.zs.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeStrings {

    /**
     * 3¡¢Longest Substring Without Repeating Characters
     * 
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        List<Character> list = new ArrayList<>();

        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            int index = list.indexOf(chars[i]);
            if (index > -1) {
                if (result < list.size()) {
                    result = list.size();
                }
                final List<Character> subList = new ArrayList<>();
                for (int j = index + 1; j < list.size(); j++) {
                    subList.add(list.get(j));
                }
                list.clear();
                list.addAll(subList);
            }
            list.add(chars[i]);
        }
        return result < list.size() ? list.size() : result;
    }
}
