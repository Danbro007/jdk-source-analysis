package algorithm.sort;

import java.util.Arrays;

/**
 * @Classname InsertSort
 * @Description TODO
 * @Date 2020/8/18 12:48
 * @Author Danrbo
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = {3, 6, 1, 20, 9, 10, 4};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int cur = array[i];// 当前要排序的元素
            int index = i - 1;// 前一个元素
            while (index >= 0 && array[index] > cur){
                array[index+1] = array[index]; // 如果大于 cur，则把当前的元素往后挪一位。
                index--;
            }
        array[index + 1] = cur;// 说明 cur 找到了它的位置，放置元素。
        }
    }
}
