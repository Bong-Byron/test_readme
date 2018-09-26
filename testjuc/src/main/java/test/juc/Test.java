package test.juc;

import test.juc.annotation.AnnoTest;
import test.juc.annotation.Person;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: Byron
 * @Date: 16:19 2018/9/13
 **/
@AnnoTest(value = "欢迎",description = "来自byron")
public class Test {

    public static void main(String[] args) throws InterruptedException {
        Person p = new Person(Test.class);
        p.getMessage("北京京");
//        System.out.println("北京");

        SynchronousQueue<String> queue = new SynchronousQueue<String>(true);
//        queue.put("a");
        System.out.println(queue.offer("v")) ;

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,5,TimeUnit.DAYS,new LinkedBlockingQueue<Runnable>()){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("开始之前");
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("之后");
            }
        };
        threadPoolExecutor.submit(()->{
            System.out.println("正在进行");
        });
        threadPoolExecutor.awaitTermination(10,TimeUnit.SECONDS);
        threadPoolExecutor.shutdown();
    }
}
