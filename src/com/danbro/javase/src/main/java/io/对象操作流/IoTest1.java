package io.对象操作流;

import java.io.*;
import java.util.ArrayList;

/**
 * @Classname IoTest1
 * @Description TODO
 * @Date 2020/8/18 11:45
 * @Author Danrbo
 */
public class IoTest1 implements Serializable {
    private final static String FILEPATH01 = "D:\\JavaSource\\jdk1.8-source-analysis\\src\\com\\danbro\\javase\\src\\main\\java\\io\\对象操作流\\objectOperate1.txt";
    private final static String FILEPATH02 = "D:\\JavaSource\\jdk1.8-source-analysis\\src\\com\\danbro\\javase\\src\\main\\java\\io\\对象操作流\\objectOperate2.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        method1();
        method2();
    }

    /**
     * 把对象序列化后保存到文件里，然后再从文件读取对象打印出来。
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void method1() throws IOException, ClassNotFoundException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILEPATH01));
        for (int i = 0; i < 3; i++) {
            Student student = new Student(i, "Alex" + i);
            outputStream.writeObject(student);
        }
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILEPATH01));
        try {
            while (true){
                Object o = inputStream.readObject();
                System.out.println(o);
            }
        } catch (EOFException e) {
            System.out.println("读取到文件尾部");
        }
    }

    public static void method2() throws IOException, ClassNotFoundException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILEPATH02));
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Student student = new Student(i, "Alex" + i);
            list.add(student);
        }
        outputStream.writeObject(list);
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILEPATH02));
        ArrayList<Student> students = (ArrayList) inputStream.readObject();
        students.forEach(System.out::println);
    }

}
