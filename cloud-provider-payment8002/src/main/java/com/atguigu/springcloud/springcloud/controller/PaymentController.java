package com.atguigu.springcloud.springcloud.controller;
import com.atguigu.springcloud.springcloud.entities.CommonResult;
import com.atguigu.springcloud.springcloud.entities.Payment;
import com.atguigu.springcloud.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Value("${server.port}")
    private String SERVER_PORT;
    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("********插入结果: " + result);
        if (result > 0){
            return new CommonResult(200, "插入数据库成功，serverPort=" + serverPort, result);
        }else {
            return  new CommonResult(444, "插入数据库失败", null);
        }
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("********查询结果: " + payment+" 哈哈222");
        int age = 10/2;
        if (payment != null){
            return new CommonResult(200, "查询成功，serverPort="+serverPort, payment);
        }else {
            return  new CommonResult(444, "没有对应记录: "+ id, null);
        }
    }
    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return SERVER_PORT;
    }
}