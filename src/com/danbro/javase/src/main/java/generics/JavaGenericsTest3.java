package generics;

/**
 * @Classname JavaGenericsTest3
 * @Description TODO
 *
 * 泛型接口
 *
 * @Date 2020/8/5 11:39
 * @Author Danrbo
 */
public class JavaGenericsTest3 {
}


interface Generator<T>{
   public T hello();
}

/**
 * 实现泛型接口 不指定类型
 * @param <T> 泛型
 */
class GeneratorImpl<T> implements Generator<T>{
    @Override
    public T hello() {
        return null;
    }
}

/**
 * 实现泛型接口并指定类型
 * @param <T>
 */
class GeneratorImpl2<T> implements Generator<String>{
    @Override
    public String hello() {
        return null;
    }
}
