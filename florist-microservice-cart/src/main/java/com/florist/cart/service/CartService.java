package com.florist.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.florist.cart.mapper.CartMapper;
import com.florist.common.pojo.CartInfo;
import com.florist.common.vo.SysResult;

//查询
@Service
public class CartService {
@Autowired
private CartMapper cartMapper;
	public List<CartInfo> queryCart(String userId) {
		return cartMapper.queryCart(userId);
	}
//新增

  public void addCart(CartInfo cartInfo){
	   CartInfo exit=cartMapper.queryOne(cartInfo);
	 if(exit!=null){
		exit.setProductCount(exit.getProductCount()
				+cartInfo.getProductCount());
      cartMapper.updateProductCount(exit);
	 }else{
		 cartMapper.addCart(cartInfo);
	 }
  }
//更新
public void updateProductCount(CartInfo cartInfo) {
	cartMapper.updateProductCount(cartInfo);
	
}
//删除
public void deleteCart(CartInfo cartInfo) {
	cartMapper.deleteCart(cartInfo);
	
}

	}
