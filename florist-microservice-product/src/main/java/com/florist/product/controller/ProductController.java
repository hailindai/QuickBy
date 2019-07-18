package com.florist.product.controller;

import org.apache.commons.math.stat.descriptive.summary.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.florist.common.pojo.ProductInfo;
import com.florist.common.vo.ProductInfoUIResult;
import com.florist.common.vo.ProductSortUIResult;
import com.florist.product.service.ProductService;

@RestController
@RequestMapping("product/manage")
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping("show")
	public ProductInfoUIResult productPageQuery(Integer page, Integer rows) {
		ProductInfoUIResult result = productService.productPageQuery(page, rows);
		return result;
	}

	@RequestMapping("showdetail")
	
	public ProductInfo queryById(String productId) {
		
		ProductInfo product = productService.queryById(productId);
		return product;
		//
	}
	
	@RequestMapping("sort/show")
	public ProductSortUIResult productTypeQuery(Integer page, Integer rows) {
		ProductSortUIResult result = productService.productTypeQuery(page, rows);
		return result;
	}
	
	
	@RequestMapping("search")
	public ProductInfoUIResult search(String productName,Integer startPrice,Integer endPrice,Integer page,Integer rows) {
		ProductInfoUIResult result = productService.searchByProductNameAndPrice(productName,startPrice,endPrice,page, rows);
		return result;
	}
	
	@RequestMapping("searchbysortname")
	public ProductInfoUIResult searchBySortName(String sortName,Integer page, Integer rows) {
		ProductInfoUIResult result = productService.searchBySortName(sortName,page, rows);
		return result;
	}
	
	@RequestMapping("create")
	public String create() {
		try {
			productService.create();
			return "ok";
		} catch (Exception e) {
			return e.getMessage();
		}
		
	}
}
