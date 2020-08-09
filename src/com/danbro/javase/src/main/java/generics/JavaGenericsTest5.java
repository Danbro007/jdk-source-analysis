package generics;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname JavaGenericsTest4
 * @Description TODO
 * <p>
 * 泛型方法
 * @Date 2020/8/5 11:42
 * @Author Danrbo
 */
public class JavaGenericsTest5 {
    /**
     * 限定了上届，既只要是 Animal 及其子类都可以
     * @param animals
     * @return
     */
    static int countLegs1(List<? extends Animal> animals) {
        int retVal = 0;
        for (Animal animal : animals) {
            retVal += animal.countLegs();
        }
        return retVal;
    }

    /**
     * 只能是 Animal 对象，其子类也不行。
     * @param animals
     * @return
     */
    static int countLegs2(List<Animal> animals) {
        int retVal = 0;
        for (Animal animal : animals) {
            retVal += animal.countLegs();
        }
        return retVal;
    }


    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        countLegs1(cats);
//        countLegs2(cats);// 不能通过编译
    }


}

@Data
class Animal {
    private int legs;

    public int countLegs() {
        return this.legs;
    }

    public Animal(int legs) {
        this.legs = legs;
    }
}


@Data
class Cat extends Animal{
    public Cat(int legs) {
        super(legs);
    }
}
