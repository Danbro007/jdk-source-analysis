package algorithm.algorithmQuestion;

/**
 * @Classname Test5
 * @Description TODO
 * <p>
 * 最长回文子串 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * @Date 2020/8/18 16:06
 * @Author Danrbo
 */
public class Test5 {
    public static void main(String[] args) {
        String str1 = "babad";
        String str2 = "cbbd";
        String s = longestPalindrome(str1);
        System.out.println(s);
    }

    private static int index = 0, len = 0;
    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        //babad
        for (int i = 0; i < s.length() - 1; i++) {
            palindromeHelper(s, i, i);
            palindromeHelper(s, i, i + 1);
        }
        return s.substring(index, index + len);
    }

    public static void palindromeHelper(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if (len < r - l - 1) {
            index = l + 1;
            len = r - l - 1;
        }
    }
}
