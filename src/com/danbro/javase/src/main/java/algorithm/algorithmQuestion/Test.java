package algorithm.algorithmQuestion;

import java.util.Arrays;
import java.util.Random;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020/8/18 12:56
 * @Author Danrbo
 */
public class Test {
    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(100);
        }
        System.out.println(Arrays.toString(array));
        insertSort(array);
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;
            int temp;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]){
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
        System.out.println(Arrays.toString(array));
    }


    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int cur = array[i];
            int index = i - 1;
            while (index >= 0 && cur < array[index]){
                array[index + 1] = array[index--];
            }
            array[index+1] = cur;
        }
        System.out.println(Arrays.toString(array));

    }
}
