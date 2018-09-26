package test.juc.annotation;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @Description:
 * @Author: Byron
 * @Date: 16:27 2018/9/13
 **/

public class Person<T> {
    Person(){

    }
    public Person(Class<T> cl){
//        Method[] methods = cl.getMethods();
        AnnoTest annoTest = cl.getAnnotation(AnnoTest.class);
        if("欢迎".equals(annoTest.value())){
            System.out.println("你好啊");
        }

    }
    public String getMessage(String name){
        System.out.println("nininin"+name);
        return name;
    }

    public String getSpeci(String message){
        System.out.println("uuuuuuu"+message);
        return message;
    }
}
