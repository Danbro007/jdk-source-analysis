package 算法.算法题;

/**
 * @Classname Test4
 * @Description TODO
 * <p>
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * <p>
 * 输入: "race a car"
 * 输出: false
 * @Date 2020/8/18 15:49
 * @Author Danrbo
 */
public class Test4 {
    public static void main(String[] args) {
        String str1 = "A man, a plan, a canal: Panama";
        String str2 = "race a car";
        System.out.println(judge(str1));
        System.out.println(judge(str2));

    }

    public static boolean judge(String str) {
        if (str.length() == 0) {
            return true;
        }
        int firstIndex = 0;
        int lastIndex = str.length() - 1;
        while (firstIndex < lastIndex) {
            if (!Character.isLetterOrDigit(str.charAt(firstIndex))) { // 忽略非字母和数字的字符
                firstIndex++;
            } else if (!Character.isLetterOrDigit(str.charAt(lastIndex))) {
                lastIndex--;
            } else {
                if (Character.toLowerCase(str.charAt(firstIndex)) != Character.toLowerCase(str.charAt(lastIndex))) {
                    return false;
                }
                firstIndex++;
                lastIndex--;
            }

        }
        return true;
    }

}
