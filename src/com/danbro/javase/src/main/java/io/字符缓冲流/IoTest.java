package io.字符缓冲流;

import java.io.*;

/**
 * @Classname IoTest
 * @Description TODO
 * @Date 2020/8/17 16:23
 * @Author Danrbo
 */
public class IoTest {
    public static void main(String[] args) throws IOException {
        File file01 = new File("D:\\JavaSource\\jdk1.8-source-analysis\\src\\com\\danbro\\javase\\src\\main\\java\\io\\字符缓冲流\\file01.txt");
        File file02 = new File("D:\\JavaSource\\jdk1.8-source-analysis\\src\\com\\danbro\\javase\\src\\main\\java\\io\\字符缓冲流\\file02.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file01.getAbsoluteFile()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file02.getAbsoluteFile()));
        int len;
        char[] chars = new char[1024];
        while ((len = reader.read(chars)) != -1) {
            writer.write(chars,0,len);
        }
        System.out.println("复制完毕");
        reader.close();
        writer.close();
    }
}
