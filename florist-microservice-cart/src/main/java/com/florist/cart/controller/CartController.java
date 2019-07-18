package com.florist.cart.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.florist.cart.service.CartService;
import com.florist.common.pojo.CartInfo;
import com.florist.common.vo.SysResult;

 @RestController
 @RequestMapping("cart/manage")
public class CartController {
 @Autowired
private CartService cartService;
//查询
  @RequestMapping("query")
  public List<CartInfo> queryCart(String userId){
	  if(!StringUtils.isNotEmpty(userId)){
		  return null;
	  }
	   List<CartInfo> cartList=cartService.queryCart(userId);
	   return cartList;
  }	
  //新增
  @RequestMapping("add")
  public SysResult addCart(CartInfo cartInfo){
	  try{
	 cartService.addCart(cartInfo);
	 return SysResult.ok();
	  }catch(Exception e){
		  e.printStackTrace();
		  return SysResult.build(201, "", null);
	  }
  }
 
  //更新
  @RequestMapping("update")
  public SysResult updateProductCount(CartInfo cartInfo){
	  try{
	  cartService.updateProductCount(cartInfo);
	  return SysResult.ok();
  }catch(Exception e){
	  e.printStackTrace();
	  return SysResult.build(201, "", null);
  }
  }
  //删除
  @RequestMapping("delete")
  public SysResult deleteCart(CartInfo cartInfo){
	  try{
	  cartService.deleteCart(cartInfo);
	  return SysResult.ok();
	  }catch(Exception e){
		  e.printStackTrace();
		  return SysResult.build(201, "", null);
	  }
  }
 }
  
 

