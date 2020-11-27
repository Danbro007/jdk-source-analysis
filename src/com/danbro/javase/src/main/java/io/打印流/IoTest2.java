package io.打印流;

import java.io.*;

/**
 * @Classname IoTest1
 * @Description TODO
 * <p>
 * 使用 PrintStream 复制文件
 * @Date 2020/8/18 11:16
 * @Author Danrbo
 */
public class IoTest2 {
    private static final String SOURCE = "D:\\JavaSource\\jdk1.8-source-analysis\\src\\com\\danbro\\javase\\src\\main\\java\\io\\打印流\\file01.txt";
    private static final String TARGET = "D:\\JavaSource\\jdk1.8-source-analysis\\src\\com\\danbro\\javase\\src\\main\\java\\io\\打印流\\file03.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(SOURCE));
        PrintStream writer = new PrintStream(new FileOutputStream(TARGET),true);
        String line;
        while ((line  = reader.readLine()) != null){
            writer.println(line);
        }
    }
}
