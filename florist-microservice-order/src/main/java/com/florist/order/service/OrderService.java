package com.florist.order.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.florist.common.pojo.OrderInfo;
import com.florist.common.pojo.UserInfo;
import com.florist.order.mapper.OrderMapper;
@Service
public class OrderService {
	@Autowired
	private OrderMapper orderMapper;
	public List<OrderInfo> orderQueryById(String userId) {
		return orderMapper.orderQueryById(userId);
	}
	public void saveOrder(OrderInfo order) {
		orderMapper.updateUser(order.getUserId());
		UserInfo userInfo=orderMapper.queryUserInfo(order.getUserId());
		order.setOrderId(order.getUserId()*10000000000L+userInfo.getHistoryOrderCount());
		order.setUserPhone(userInfo.getUserPhone());
		order.setUserAddress(userInfo.getUserAddress());
		order.setUserRealName(userInfo.getUserRealName());
		orderMapper.updateProduct(order.getProductId());
		orderMapper.saveOrder(order);
		orderMapper.deleteCart(order);
	}
	public void deleteOrder(String orderId) {
		orderMapper.deleteOrder(orderId);
	}
}
