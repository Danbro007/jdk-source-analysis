package Multithread.ThreadPool;

import lombok.Data;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Classname NameThreadFactory
 * @Description TODO
 *
 *  能对线程池命名
 *
 * @Date 2020/8/13 20:33
 * @Author Danrbo
 */
@Data
public class NameThreadFactory implements ThreadFactory {
    private ThreadFactory threadFactory;
    private String name;

    public NameThreadFactory(String name) {
        this.threadFactory = Executors.defaultThreadFactory();
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        return threadFactory.newThread(r);
    }
}
