package classquestion;

/**
 * @Classname ClassTest1
 * @Description TODO
 *
 * 当子类调用父类的方法时，父类的方法里会调用被子类重写过的方法，则会优先调用子类的重写的方法。
 *
 * @Date 2020/8/5 12:08
 * @Author Danrbo
 */
public class ClassTest1 {
    public static void main(String[] args) {
        B b = new B();
        b.func1();
    }
}

class A{
    public void func1(){
        System.out.println("func1 from A");
        // 优先调用子类的 fun2()
        func2();
    }

    public void func2() {
        System.out.println("func2 from A");

    }
}
class B extends A {
    @Override
    public void func1(){
        System.out.println("func1 from B");
        super.func1();
    }

    @Override
    public void func2() {
        System.out.println("func2 from B");
    }
}
