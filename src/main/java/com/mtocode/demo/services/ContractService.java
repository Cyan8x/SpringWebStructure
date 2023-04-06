package com.mtocode.demo.services;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mtocode.demo.common.OnlinePaymentService;
import com.mtocode.demo.common.VisaPaymentService;
import com.mtocode.demo.dto.ContractRequestDTO;
import com.mtocode.demo.entities.Contract;
import com.mtocode.demo.entities.Quota;

@Service
public class ContractService {
	
	OnlinePaymentService onlinePaymentService;
	
	public ContractService(VisaPaymentService visaPaymentService) {
		this.onlinePaymentService = visaPaymentService;
	}
	
	public Contract proceedService(ContractRequestDTO contractRequest){
		
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		List<Quota> cuotas = new ArrayList<>();
		
		
		Contract contractResponseNoDB = new Contract();
		try {
			contractResponseNoDB.setFecha_contrato(formatDate.parse(contractRequest.getFecha_contrato()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contractResponseNoDB.setImporte_total(contractRequest.getImporte_total());
		contractResponseNoDB.setNro_contrato(contractRequest.getNro_contrato());
		
		Double basicQuota = contractRequest.getImporte_total()/contractRequest.getCant_meses();
		
		for (int i = 1; i <= contractRequest.getCant_meses(); i++) {
			Double fullQuota = basicQuota + onlinePaymentService.interest(basicQuota) + onlinePaymentService.paymentsFee(basicQuota);
			Date fechaCuota = contractResponseNoDB.getFecha_contrato();
			c.setTime(fechaCuota);
			c.add(Calendar.MONTH, i);
			Quota cuota = new Quota(c.getTime(),fullQuota);
			cuotas.add(cuota);
		}
		
		contractResponseNoDB.setQuotas(cuotas);
		
		return contractResponseNoDB;
	}
	
//	static Double paymentsFee(Double amount) {
//		return amount * 0.02;
//	}
//
//	static Double interest(Double amount) {
//		return amount * 0.01;
//	} 
	
}
