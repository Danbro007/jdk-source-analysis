package classquestion;

/**
 * @Classname ClassTest3
 * @Description TODO
 *
 * 被哪些装饰的方法不能被子类重写
 *
 * @Date 2020/8/5 12:15
 * @Author Danrbo
 */
public class ClassTest3 {
}


class Aclass{
    /**
     * 以下三种都不能被子类重写
     * static 方法能被子类重新声明,另外两个不能。
     */
    public static void func1(){}
    public final void func2(){}
    private void func3(){}

    /**
     * 能被子类重写
     */
    public void fun4(){}
}

class Bclass extends Aclass{
    /**
     * 可以重新声明 static 方法
     */
    public static void func1(){}

}