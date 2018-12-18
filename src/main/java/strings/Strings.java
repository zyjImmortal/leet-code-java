
package strings;

import java.util.*;

/**
 * Solution
 */
public class Strings {

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。  输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是
     * abc"，所以其长度为      *
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        int start = 0;
        int length = 0;
        HashMap<Character, Integer> data = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // 在新的字符出现在字典中并且，开始的位置要小于等于之前出现字符的位置
            // (如果开始的位置大于旧的位置还要更新起点-此时新位置到旧位置之间出现相同的字符就会导致长度计算偏大)
            if (data.containsKey(s.charAt(i)) && start <= (int) data.get(s.charAt(i))) {
                int position = (int) data.get(s.charAt(i));
                start = position + 1;
            }
            if (i - start + 1 > length) {
                length = i - start + 1;
            }
            data.put(s.charAt(i), i);
        }
        return length;
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 思路：
     * 将每个字符串的字母挨个同时取出来依次放入集合中，如果集合的大小等于1，说明所有字母是一样的，将其追加到builder
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder("");
        HashSet set = new HashSet();
        if (strs.length == 0) {
            return builder.toString();
        }
        int minLength = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
            }
        }
        for (int i = 0; i < minLength; i++) {
            for (int j = 0; j < strs.length; j++) {
                set.add(strs[j].charAt(i));
            }
            if (set.size() == 1) {
                builder.append(strs[0].charAt(i));
            } else if (set.size() > 1) {
                break;
            }
            set.clear();
        }

        return builder.toString();
    }

    /**
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
     * <p>
     * 换句话说，第一个字符串的排列之一是第二个字符串的子串
     * 思路：
     * 看s1里的字符是否都在s2中存在，如果有不存在的则返回false，如果都存在将s1的每个字符的索引取出来放到数组中，
     * 将其排序后判断是否是一个差值为1的等差数列，如果是则返回true，如果不是则返回false
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        List<Integer> position = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            int temp = s2.indexOf(s1.charAt(i));
            if (temp == -1) {
                return false;
            }
            position.add(temp);
        }
        Collections.sort(position);
        for (int i = 0, j = 1; i < s1.length() - 1 && j < s1.length(); i++, j++) {
            if ((position.get(j) - position.get(i)) != 1) {
                return false;
            }
        }

        return true;
    }

    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }
        StringBuilder bs = new StringBuilder();
        for (int p : pos) {
            if (!(bs.length() == 0 && p == 0)) {
                bs.append(p);
            }
        }
        return bs.length() == 0 ? "0" : bs.toString();
    }

    /**
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     *
     * 示例:
     *      输入: "the sky is blue",
     *      输出: "blue is sky the".
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] arrays = s.split(" ");

        StringBuilder bs = new StringBuilder();
        int length = arrays.length;
        for (int i = length - 1 ; i >= 0 ; i--) {
            if (!arrays[i].equals(""))
                bs.append(arrays[i] + " ");
        }
        return bs.toString().trim();
    }

    public static void main(String[] args) {
//        String s = "abba";
//        String[] strs = new String[]{"flower", "flowttttt", "flowight"};
//        String[] strs = new String[]{};
//        String[] strings = new String[]{"aca", "cba"};
        String num1 = "the sky is blue";
        String num2 = "   a   b ";
//        System.out.println(5 % 3);
//        String s1 = "ab";
//        String s2 = "eidbaooo";
        Solution solution = new Solution();
        System.out.println(solution.reverseWords(num2));
    }
}
