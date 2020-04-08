package com.atguigu.springcloud.springcloud.service;

import com.atguigu.springcloud.springcloud.entities.Payment;

public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(Long id);
}
