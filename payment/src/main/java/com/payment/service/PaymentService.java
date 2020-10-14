package com.payment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.model.Payment;
import com.payment.model.WashOrder;
import com.payment.repo.PaymentRepo;
import com.payment.repo.WashOrderRepo;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepo paymentRepo;

	@Autowired
	private WashOrderRepo orderRepo;

	public Payment savePaymentDetails(Payment payment) {
		Optional<WashOrder> order = orderRepo.findById(payment.getOrderId());
		if (order.isPresent()) {
			WashOrder temp = order.get();
			temp.setPaymentStatus(true);
			Payment savedPayment = paymentRepo.save(payment);
			temp.setPaymentId(savedPayment.getPaymentId());
			orderRepo.save(temp);
			return savedPayment;
		}
		return null;
	}
}
