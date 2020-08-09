package generics;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname JavaGenericsTest7
 * @Description TODO
 * @Date 2020/8/7 14:31
 * @Author Danrbo
 */
public class JavaGenericsTest7 {
    public static void main(String[] args) {
        ArrayList<E> list = new ArrayList<>();
        list.add(new E(1));
        list.add(new E(2));
        list.add(new E(3));
        list.add(new E(4));
        test(list);
    }

    /**
     * 只要 list 里的元素类型是 G 的父类或者自身就可以
     * @param list
     */
    public static void test(List<? super G> list){
        System.out.println(list);
    }
}
@Data
class E{
    private int id;
    public E(int i) {
        this.id = i;
    }
}
@Data
class G extends E{
    public G(int i) {
        super(i);
    }
}


