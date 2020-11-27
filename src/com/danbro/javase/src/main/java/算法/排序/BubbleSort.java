package 算法.排序;

import java.util.Arrays;

/**
 * @Classname BubbleSort
 * @Description TODO
 * @Date 2020/8/17 10:13
 * @Author Danrbo
 */
public class BubbleSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int temp;
            boolean flag = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 6, 1, 20, 9, 10, 4};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

}
