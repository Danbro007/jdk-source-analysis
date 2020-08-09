package generics;

import lombok.Data;

/**
 * @Classname JavaGenericsTest6
 * @Description TODO
 * @Date 2020/8/7 14:16
 * @Author Danrbo
 */
public class JavaGenericsTest6 {
    public static void main(String[] args) {
        D test = test(new C(), new D());
//        test(new D(),new C())//编译不通过
    }

    /**
     * 参数列表，多个参数之间用逗号隔开。
     * @param arg1
     * @param arg2
     * @param <C>
     * @param <D>
     * @return
     */
    public static < C extends A,D extends B>  D test(C arg1,D arg2){
        D result = arg2;
        System.out.println("arg1===="+arg1);
        System.out.println("arg2===="+arg2);
        return result;
    }
}

class A{
}
class B{
}

@Data
class C extends A {
    private int id = 3;

}
@Data
class D extends B{
    private int id = 4;
}
