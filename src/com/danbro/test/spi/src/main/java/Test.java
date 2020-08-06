import interfaces.Developer;

import java.util.ServiceLoader;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020/7/6 14:35git
 * @Author Danrbo
 */
public class Test {
    public static void main(String[] args) {
        ServiceLoader<Developer> developers = ServiceLoader.load(Developer.class);
        developers.forEach(Developer::sayHi);
    }
}
