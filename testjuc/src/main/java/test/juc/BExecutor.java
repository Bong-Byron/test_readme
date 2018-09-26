package test.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: Byron
 * @Date: 10:53 2018/9/11
 **/
public class BExecutor {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("画好人帅");
            }
        });
        executorService.shutdown();
        executorService.awaitTermination(1,TimeUnit.HOURS);

        //schedule
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("画好人帅1");
            }
        },1,2,TimeUnit.SECONDS);

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("画好人帅2");
            }
        },1,2,TimeUnit.SECONDS);





    }


}
