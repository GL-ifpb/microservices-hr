package com.humanresource.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.humanresource.hrpayroll.entities.Payment;
import com.humanresource.hrpayroll.entities.Worker;
import com.humanresource.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	//@Value("${hr-worker.host}")
	//private String workerHost;	
	
	//@Autowired
	//private RestTemplate restTemplate;
	
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, int days) {
		
		//Map<String, String> uriVariables = new HashMap<>();
		//uriVariables.put("id", ""+workerId);
		
		//Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
		
		Worker worker = workerFeignClient.findById(workerId).getBody();
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
		
	}
	
}
