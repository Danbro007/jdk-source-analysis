package impl;

import interfaces.Developer;

/**
 * @Classname JavaDeveloper
 * @Description TODO
 * @Date 2020/7/6 14:30
 * @Author Danrbo
 */
public class JavaDeveloper implements Developer {
    @Override
    public void sayHi() {
        System.out.println("this is a JavaDeveloper");
    }
}
