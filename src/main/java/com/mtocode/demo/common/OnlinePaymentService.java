package com.mtocode.demo.common;

import org.springframework.stereotype.Component;

@Component
public interface OnlinePaymentService {
	public Double paymentsFee(Double amount);
	public Double interest(Double amount);
}
