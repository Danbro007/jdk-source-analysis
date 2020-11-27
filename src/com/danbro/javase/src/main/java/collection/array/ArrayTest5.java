package collection.array;

/**
 * @Classname ArrayTest4
 * @Description TODO
 *
 * 测试 System.arraycopy() 方法的实现效果
 *
 * @Date 2020/8/6 10:18
 * @Author Danrbo
 */
public class ArrayTest5 {
    public static void main(String[] args) {
        int[] a = new int[10];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        // 原数组 {0,1,2,3,0,0,0,0,0,0}
        // 从索引 2 开始往后数 3 个元素 拷贝到原数组的索引 3 的位置。
        // 既把 2,3,0 这三个元素复制到索引 3 的位置
        // {0,1,2,2,3,0,0,0,0,0} 然后再把索引 2 位置的元素设置成 99
        // {0,1,99,2,3,0,0,0,0,0}
        System.arraycopy(a, 2, a, 3, 3);
        a[2]=99;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
