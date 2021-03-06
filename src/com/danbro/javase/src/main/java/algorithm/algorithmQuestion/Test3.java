package algorithm.algorithmQuestion;

/**
 * @Classname Test3
 * @Description TODO
 *
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @Date 2020/8/18 13:55
 * @Author Danrbo
 */
public class Test3 {
    public static void main(String[] args) {
        String str = "We Are Happy";
        String newStr = replaceSpace1(str);
        System.out.println(newStr);

    }
    public static String replaceSpace1(String str){
        char[] chars = str.toCharArray();
        StringBuilder stringBuffer = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == ' ') {
                stringBuffer.append("%20");
            } else {
                stringBuffer.append(aChar);
            }
        }
        return stringBuffer.toString();
    }
}
