package com.mtocode.demo.common;

import org.springframework.stereotype.Component;

@Component
public class VisaPaymentService implements OnlinePaymentService{

	@Override
	public Double paymentsFee(Double amount) {
		return amount * 0.05;
	}

	@Override
	public Double interest(Double amount) {
		return amount * 0.03;
	}

}
