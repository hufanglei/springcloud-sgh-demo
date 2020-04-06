package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentinfo_ok,id:" + id + "\t"+"O(∩_∩)O哈哈~";
    }


    /**
     * 超时访问
     * * HystrixCommand:一旦调用服务方法失败并抛出了错误信息后,会自动调用@HystrixCommand标注好的fallbckMethod调用类中的指定方法
     * * execution.isolation.thread.timeoutInMilliseconds:线程超时时间3秒钟
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
//        int timeNumber = 5;
        int age = 10 / 0; //模拟系统运行异常
//        try {
//            TimeUnit.SECONDS.sleep(timeNumber);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "线程池：" + Thread.currentThread().getName() + " paymentinfo_Timeout,id:" + id + "\t" + "耗时(秒)" + timeNumber;
        return "线程池：" + Thread.currentThread().getName() + " paymentinfo_Timeout,id:" + id + "\t" + "耗时(秒)";
    }

    private String paymentInfo_TimeOutHandler(Integer id) {
//        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_TimeOutHandler,id:" + id + "\t" + "~~~~(>_<)~~~~";
        return "线程池：" + Thread.currentThread().getName() + " 8001系统繁忙或者运行报错,请稍后再试,id:" + id + "\t" + "~~~~(>_<)~~~~";
    }
}
