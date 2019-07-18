package com.florist.cart.mapper;

import java.util.List;

import com.florist.common.pojo.CartInfo;

public interface CartMapper {
//查询
	List<CartInfo> queryCart(String userId);
	CartInfo queryOne(CartInfo cartInfo);
//新增
	void addCart(CartInfo cartInfo);
//更新	
	void updateProductCount(CartInfo cartInfo);
//删除
	void deleteCart(CartInfo cartInfo);	

}
