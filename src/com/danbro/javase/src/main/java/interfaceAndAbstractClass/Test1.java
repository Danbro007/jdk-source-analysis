package interfaceAndAbstractClass;

/**
 * @Classname Test
 * @Description TODO
 *
 * 抽象类与普通类的区别
 *
 * @Date 2020/8/16 13:31
 * @Author Danrbo
 */
public class Test1 {
    public static void main(String[] args) {
//        new AAbstract() // 抽象类不能被实例化
        A a = new A();// 普通类能实例化

    }
}

class A{
//    abstract void func1();// 普通类不能有抽象方法。


}


abstract class AAbstract{
    abstract void func1();

}
