package io.字节缓冲流;

import io.字节流.IoTest;

import java.io.File;
import java.io.IOException;

/**
 * @Classname IoTest02
 * @Description TODO
 *
 * 字节流与缓冲流复制文件效率对比
 *
 * @Date 2020/8/17 16:51
 * @Author Danrbo
 */
public class IoTest02 {
    public static void main(String[] args) throws IOException {
        File file01 = new File("D:\\JavaSource\\jdk1.8-source-analysis\\src\\com\\danbro\\javase\\src\\main\\java\\io\\字节缓冲流\\bigfile01.pdf");
        File file02 = new File("D:\\JavaSource\\jdk1.8-source-analysis\\src\\com\\danbro\\javase\\src\\main\\java\\io\\字节缓冲流\\bigfile02.pdf");
        File file03 = new File("D:\\JavaSource\\jdk1.8-source-analysis\\src\\com\\danbro\\javase\\src\\main\\java\\io\\字节缓冲流\\bigfile03.pdf");
        IoTest.method1(file01,file02);
        io.字节缓冲流.IoTest.method1(file01,file03);
    }
}
