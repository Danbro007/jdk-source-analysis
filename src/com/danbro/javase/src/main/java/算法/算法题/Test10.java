package 算法.算法题;

import java.io.*;

/**
 * @Classname Test10
 * @Description TODO
 * @Date 2020/8/19 11:29
 * @Author Danrbo
 */
public class Test10 {
    private static final String FILEPATH = "D:\\JavaSource\\jdk1.8-source-analysis\\src\\com\\danbro\\javase\\src\\main\\java\\算法\\算法题\\sparseArray.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //创建11*11的二维数组 0代表没有棋子 1代表黑子 2代表蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        System.out.println("转换前");
        printArray(chessArr1);
        int sum = sum(chessArr1);
        System.out.println("有效元素数为：" + sum);
        int[][] sparseArray = getSparseArray(chessArr1, sum);
        System.out.println("稀疏数组：");
        printArray(sparseArray);
        System.out.println("保存稀疏数组到文件上");
        saveSparseArray(sparseArray, FILEPATH);
        int[][] sparseArrayFromFile = getSparseArrayFromFile(FILEPATH);
        System.out.println("从文件读取稀疏数组");
        printArray(sparseArrayFromFile);
        System.out.println("把稀疏数组还原为原数组");
        int[][] array = recoverArrayFromSparseArray(sparseArray);
        printArray(array);


    }

    /**
     * 统计数组里的非零数的数量
     *
     * @param chessArr 二维数组
     * @return 非零数的数量
     */
    public static int sum(int[][] chessArr) {
        int count = 0;
        for (int[] ints : chessArr) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int[][] getSparseArray(int[][] chessArray, int sum) {
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        int m = 1;
        for (int i = 0; i < chessArray.length; i++) {
            for (int j = 0; j < chessArray[i].length; j++) {
                if (chessArray[i][j] != 0) {
                    sparseArray[m][0] = i;
                    sparseArray[m][1] = j;
                    sparseArray[m][2] = chessArray[i][j];
                    m++;
                }
            }
        }
        return sparseArray;
    }


    public static void saveSparseArray(int[][] chessArray, String Destination) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Destination));
        oos.writeObject(chessArray);
    }

    public static int[][] getSparseArrayFromFile(String Source) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Source));
        return (int[][]) ois.readObject();
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%d\t", array[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] recoverArrayFromSparseArray(int[][] sparseArray) {
        int[][] array = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            array[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return array;
    }

}
