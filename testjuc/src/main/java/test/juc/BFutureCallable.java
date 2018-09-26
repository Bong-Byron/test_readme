package test.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description:
 * @Author: Byron
 * @Date: 16:38 2018/9/10
 **/
public class BFutureCallable implements Callable<String> {


    @Override
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<3;i++){
            sb.append("byron is good man").append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new BFutureCallable());
        new Thread(task).start();
//        task.cancel(true);
        String result = task.get();
        System.out.println(result);

    }


}
