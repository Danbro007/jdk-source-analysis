package algorithm.algorithmQuestion;


import java.util.Arrays;

/**
 * @Classname Test2
 * @Description TODO
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * @Date 2020/8/18 13:15
 * @Author Danrbo
 */
public class Test2 {
    public static void main(String[] args) {
        String[] array1 = {"flower", "flow", "flight"};
        String[] array2 = {"dog", "racecar", "car"};
        judge(array2);

    }

    public static void judge(String[] array) {
        if (array.length<= 0){
            throw new RuntimeException("数组为空");
        }

        Arrays.sort(array);
        StringBuffer stringBuffer = new StringBuffer();
        String first = array[0];
        String last = array[array.length - 1];
        int min = Math.min(first.length(), last.length());
        boolean flag = false;
        for (int i = 0; i < min; i++) {
            if (first.charAt(0) != last.charAt(0)){
                break;
            }
            if (first.charAt(i) == last.charAt(i)) {
                if (flag) {
                    stringBuffer = new StringBuffer();
                }
                stringBuffer.append(first.charAt(i));
            } else {
                flag = true;
            }
        }
        System.out.println("".equals(stringBuffer.toString())?"无":stringBuffer);

    }
}
