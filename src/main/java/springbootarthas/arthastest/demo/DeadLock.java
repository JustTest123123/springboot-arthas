package springbootarthas.arthastest.demo;

import java.util.concurrent.TimeUnit;

/**
 * @author wenbaox
 * @version 1.0
 * @date 2021/5/8 上午8:38
 */
public class DeadLock {
    //死锁演示
    public static final String lock1 = "lock1";
    public static final String lock2 = "lock2";
    public static void main(String[] args) {
        new Thread(() ->{
            synchronized (lock1) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread");
                synchronized (lock2) {

                }
            }

        },"thread lock1").start();


        new Thread(() ->{
            synchronized (lock2) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread");
                synchronized (lock1) {

                }
            }

        },"thread lock2").start();
    }

}
    