package com.order.washorder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.order.washorder.model.Customer;
import com.order.washorder.model.OrderDetails;
import com.order.washorder.model.Payment;
import com.order.washorder.model.WashOrder;
import com.order.washorder.model.WashPackage;
import com.order.washorder.model.Washer;
import com.order.washorder.repo.CustomerRepo;
import com.order.washorder.repo.OrderRepo;
import com.order.washorder.repo.PaymentsRepo;
import com.order.washorder.repo.WashPackageRepo;
import com.order.washorder.repo.WasherRepo;

@Service
public class WashOrderService {
	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private WasherRepo washerRepo;
	@Autowired
	private WashPackageRepo washPackageRepo;
	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private PaymentsRepo paymentsRepo;

	public Customer getCustomer(String emailId) {
		return customerRepo.findById(emailId).get();

	}

	public Washer getWasher(String emailId) {
		return washerRepo.findById(emailId).get();
	}

	public WashPackage getPackage(String packageID) {
		return washPackageRepo.findById(packageID).get();
	}

	public List<WashOrder> getAllOrders() {
		return orderRepo.findAll();
	}

	public OrderDetails settingUp(WashOrder temp) {
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setCarModel(temp.getCarModel());
		orderDetails.setCarNumber(temp.getCarNumber());
		orderDetails.setCustomerId(temp.getCustomerId());
		orderDetails.setDate(temp.getDate());
		orderDetails.setLocation(temp.getLocation());
		orderDetails.setOrderStatus(temp.getOrderStatus());
		orderDetails.setOrderId(temp.getOrderId());
		orderDetails.setTime(temp.getTime());
		orderDetails.setPaymentStatus(temp.isPaymentStatus());
		orderDetails.setPaymentId(temp.getPaymentId());

		orderDetails.setRating(temp.getRating());
		orderDetails.setComments(temp.getComments());
		if (temp.isPaymentStatus()) {
			Optional<Payment> paytemp = paymentsRepo.findById(temp.getPaymentId());
			if (paytemp.isPresent()) {
				Payment payment = paytemp.get();
				orderDetails.setPaymentCardNumber(payment.getCardNumber());
			}

		}

		return orderDetails;
	}

	public List<OrderDetails> customerInProgressRequests(String customerId) {
		List<WashOrder> allOrders = orderRepo.findAll();
		List<OrderDetails> requiredList = new ArrayList<OrderDetails>();
		for (WashOrder temp : allOrders) {
			if (temp.getCustomerId() != null) {
				if (temp.getCustomerId().contentEquals(customerId)
						&& ((temp.getOrderStatus().contentEquals("IN PROGRESS"))
								|| (temp.getOrderStatus().contentEquals("REQUESTED")))) {
					OrderDetails orderDetails = new OrderDetails();
					orderDetails.setCarModel(temp.getCarModel());
					orderDetails.setCarNumber(temp.getCarNumber());
					orderDetails.setCustomerId(temp.getCustomerId());
					orderDetails.setDate(temp.getDate());
					orderDetails.setLocation(temp.getLocation());
					orderDetails.setOrderStatus(temp.getOrderStatus());
					orderDetails.setOrderId(temp.getOrderId());
					orderDetails.setTime(temp.getTime());

					Optional<Customer> tempCustomer = customerRepo.findById(temp.getCustomerId());
					Customer cust = new Customer();
					if (tempCustomer.isPresent()) {
						cust = tempCustomer.get();
					}
					if (temp.getWasherId() != null) {
						Optional<Washer> tempWasher = washerRepo.findById(temp.getWasherId());
						Washer washer = new Washer();
						if (tempWasher.isPresent()) {
							washer = tempWasher.get();
						}
						orderDetails.setWasherName(washer.getName());
						orderDetails.setWasherPhoneNumber(washer.getPhoneNumber());
					}
					Optional<WashPackage> pack = washPackageRepo.findById(temp.getPackageId());
					WashPackage packtemp = new WashPackage();
					if (pack.isPresent()) {
						packtemp = pack.get();
					}

					orderDetails.setOrderPackageName(packtemp.getPackageName());
					orderDetails.setOrderPackageDescription(packtemp.getPackageDescription());
					orderDetails.setOrderPackagePrice(packtemp.getPackageCost());
					;

					requiredList.add(orderDetails);

				}

			}
		}

		return requiredList;

	}

	public List<OrderDetails> getAllCustomerRequests() {
		System.out.println("in service");
		List<WashOrder> allOrders = getAllOrders();
		List<OrderDetails> requiredList = new ArrayList<OrderDetails>();
		for (WashOrder temp : allOrders) {
			System.out.println("in for");
			if (temp.getOrderStatus().contentEquals("REQUESTED")) {
				System.out.println("in IF");
				OrderDetails orderDetails = settingUp(temp);
				System.out.println("after setting up");
				System.out.println(orderDetails);

				Customer cus = getCustomer(temp.getCustomerId());
				if (cus != null) {
					orderDetails.setCustomerName(cus.getName());
					orderDetails.setCustomerPhoneNumber(cus.getMobileNumber());
				}
				WashPackage pack = getPackage(temp.getPackageId());
				if (pack != null) {
					orderDetails.setOrderPackageDescription(pack.getPackageDescription());
					orderDetails.setOrderPackageName(pack.getPackageName());
					orderDetails.setOrderPackagePrice(pack.getPackageCost());
				}

				requiredList.add(orderDetails);

			}

		}
		System.out.println("list" + requiredList);
		return requiredList;

	}

	public List<OrderDetails> customerOldRequests(String customerId) {
		List<WashOrder> allOrders = getAllOrders();
		List<OrderDetails> requiredList = new ArrayList<OrderDetails>();

		for (WashOrder temp : allOrders) {
			if (temp.getCustomerId().contentEquals(customerId) && temp.getOrderStatus().contentEquals("SERVED")) {
				OrderDetails orderDetails = settingUp(temp);
				Washer washer = getWasher(temp.getWasherId());
				orderDetails.setWasherName(washer.getName());
				orderDetails.setWasherPhoneNumber(washer.getPhoneNumber());

				WashPackage pack = getPackage(temp.getPackageId());

				orderDetails.setOrderPackageName(pack.getPackageName());
				orderDetails.setOrderPackageDescription(pack.getPackageDescription());
				orderDetails.setOrderPackagePrice(pack.getPackageCost());

				requiredList.add(orderDetails);

			}

		}
		return requiredList;

	}

	public List<OrderDetails> washerInprogress(String emailId) {
		List<WashOrder> allOrders = getAllOrders();
		List<OrderDetails> requiredList = new ArrayList<OrderDetails>();
		for (WashOrder temp : allOrders) {
			if (temp.getWasherId() != null) {
				if (temp.getWasherId().contentEquals(emailId) && temp.getOrderStatus().contentEquals("IN PROGRESS")) {

					OrderDetails orderDetails = settingUp(temp);

					Customer customer = getCustomer(temp.getCustomerId());
					orderDetails.setCustomerName(customer.getName());
					orderDetails.setCustomerPhoneNumber(customer.getMobileNumber());

					WashPackage pack = getPackage(temp.getPackageId());

					orderDetails.setOrderPackageName(pack.getPackageName());
					orderDetails.setOrderPackageDescription(pack.getPackageDescription());
					orderDetails.setOrderPackagePrice(pack.getPackageCost());

					requiredList.add(orderDetails);

				}

			}

		}

		return requiredList;

	}

	public List<OrderDetails> washerOldRequests(String emailId) {
		List<WashOrder> allOrders = getAllOrders();
		List<OrderDetails> requiredList = new ArrayList<OrderDetails>();

		for (WashOrder temp : allOrders) {
			if (temp.getWasherId() != null) {
				if (temp.getWasherId().contentEquals(emailId) && temp.getOrderStatus().contentEquals("SERVED")) {
					OrderDetails orderDetails = settingUp(temp);

					Customer customer = getCustomer(temp.getCustomerId());
					orderDetails.setCustomerName(customer.getName());
					orderDetails.setCustomerPhoneNumber(customer.getMobileNumber());

					WashPackage pack = getPackage(temp.getPackageId());

					orderDetails.setOrderPackageName(pack.getPackageName());
					orderDetails.setOrderPackageDescription(pack.getPackageDescription());
					orderDetails.setOrderPackagePrice(pack.getPackageCost());

					requiredList.add(orderDetails);

				}

			}

		}

		return requiredList;

	}

}
