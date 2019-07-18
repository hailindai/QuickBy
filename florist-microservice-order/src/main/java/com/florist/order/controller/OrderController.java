package com.florist.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.florist.common.pojo.OrderInfo;
import com.florist.common.vo.OrderInfoUIResult;
import com.florist.common.vo.SysResult;
import com.florist.order.service.OrderService;

@RestController
@RequestMapping("order/manage")
public class OrderController {
//订单查询
	@Autowired
	private OrderService orderService;
	@RequestMapping("query/{userId}")
	public OrderInfoUIResult orderQueryById(@PathVariable String userId){
		OrderInfoUIResult result = new OrderInfoUIResult();
		List<OrderInfo> orderList = orderService.orderQueryById(userId);
		result.setRows(orderList);
		result.setTotal(orderList.size());
		return result;
	}
	//订单新增
	@RequestMapping("add")
	public SysResult saveOrder(OrderInfo order){
		try{
			orderService.saveOrder(order);
			return SysResult.ok();
		}catch(Exception e){
			e.printStackTrace();
			return SysResult.build(201, e.getMessage(), null);
		}
	}
	//订单删除
	@RequestMapping("delete/{orderId}")
	public SysResult deleteOrder(@PathVariable
			String orderId){
		try{
			orderService.deleteOrder(orderId);
			return SysResult.ok();
		}catch(Exception e){
			e.printStackTrace();
			return SysResult.build(201, "", null);
		}
	}
}
