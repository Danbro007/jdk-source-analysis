package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Classname SelectSort
 * @Description TODO
 * @Date 2020/8/19 10:32
 * @Author Danrbo
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(100);
        }
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {// 从头到尾获取每一个元素
            int minIndex = i;// 标记位
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {// 找到最小值的index和值
                if (min > array[j]) {
                    minIndex = j;
                    min = array[j];
                }
            }

            if (minIndex != i){// 如果最小值有变化则交换位置
                array[minIndex] = array[i];
                array[i] = min;
            }

        }
    }
}
