package reference;

/**
 * @Classname M
 * @Description TODO
 * @Date 2020/12/4 11:28
 * @Author Danrbo
 */
public class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("M----finalize");
    }
}
