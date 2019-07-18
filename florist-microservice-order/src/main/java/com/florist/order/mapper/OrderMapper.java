package com.florist.order.mapper;

import java.util.List;

import com.florist.common.pojo.OrderInfo;
import com.florist.common.pojo.UserInfo;

public interface OrderMapper {

	List<OrderInfo> orderQueryById(String userId);

	Object saveOrder(OrderInfo order);

	void deleteOrder(String orderId);

	void updateUser(Integer userId);

	void updateProduct(Integer productId);

	void deleteCart(OrderInfo order);

	UserInfo queryUserInfo(Integer userId);

}
