package com.customerwashrequest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerwashrequest.pojo.WashOrder;
import com.customerwashrequest.repo.WashOrderRepo;

@Service
public class WashOrderService {

	@Autowired
	private WashOrderRepo repo;

	public WashOrder saveOrder(WashOrder order) {
		order.setPaymentStatus(false);
		order.setPaymentId(null);
		order.setOrderStatus("REQUESTED");
		order.setWasherId(null);
		return repo.save(order);

	}

	public WashOrder acceptingOrder(WashOrder order) {
		System.out.println("in service");
		System.out.println(order.getOrderId() + "washerId is" + order.getWasherId());
		WashOrder temp = repo.findById(order.getOrderId()).get();

		temp.setWasherId(order.getWasherId());

		temp.setOrderStatus("IN PROGRESS");
		return repo.save(temp);

	}

	public WashOrder orderServed(WashOrder order) {
		WashOrder temp = repo.findById(order.getOrderId()).get();
		temp.setOrderStatus("SERVED");

		return repo.save(temp);

	}

	public WashOrder savingfeedback(WashOrder order) {
		Optional<WashOrder> temp = repo.findById(order.getOrderId());
		if (temp.isPresent()) {
			WashOrder exists = temp.get();
			exists.setRating(order.getRating());
			exists.setComments(order.getComments());
			return repo.save(exists);
		}
		return null;
	}

}
