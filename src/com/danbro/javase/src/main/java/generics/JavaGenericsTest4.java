package generics;

/**
 * @Classname JavaGenericsTest4
 * @Description TODO
 *
 * 泛型方法
 *
 * @Date 2020/8/5 11:42
 * @Author Danrbo
 */
public class JavaGenericsTest4 {
    public static <E> void printArray(E[] inputArray) {
        for (E e : inputArray) {
            System.out.println(e);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] intArray = {1,2,3};
        String[] stringArray = {"a","b","c"};

        printArray(intArray);
        printArray(stringArray);
    }
}
