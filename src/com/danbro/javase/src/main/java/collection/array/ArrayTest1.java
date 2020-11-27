package collection.array;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname collection.array.ArrayTest1
 * @Description TODO
 * @Date 2020/8/5 14:06
 * @Author Danrbo
 */
public class ArrayTest1 {
    public static void main(String[] args) {
        int[] myArray = { 1, 2, 3 };//如果传入的是类型是基本数据类型则 Arrays.asList() 方法获取参数是数组的内存地址而不是数组里的元素
        List myList = Arrays.asList(myArray);
        System.out.println(myList.size());//1
        System.out.println(myList.get(0));//数组地址值
        System.out.println(myList.get(1));//报错：ArrayIndexOutOfBoundsException
        int [] array=(int[]) myList.get(0);
        System.out.println(array[0]);//1
    }
}
