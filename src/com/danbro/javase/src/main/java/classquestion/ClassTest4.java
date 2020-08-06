package classquestion;

/**
 * @Classname ClassTest4
 * @Description TODO
 * @Date 2020/8/5 12:49
 * @Author Danrbo
 */
public class ClassTest4 {
    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.bar();
    }
}


class Super {
    protected int number = 20;

    protected void showNumber() {
        System.out.println("number = " + number);
    }
}

class Sub extends Super {
    void bar() {
        this.number = 10;
        super.showNumber();
    }
}
