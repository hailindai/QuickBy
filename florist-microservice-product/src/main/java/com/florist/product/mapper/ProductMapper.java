package com.florist.product.mapper;

import java.util.List;

import org.apache.commons.math.stat.descriptive.summary.Product;
import org.apache.ibatis.annotations.Param;

import com.florist.common.pojo.ProductInfo;
import com.florist.common.pojo.ProductSort;

public interface ProductMapper {
	//分页查询
	Integer queryTotal();
	List<ProductInfo> queryByPage(@Param("start")Integer start, @Param("rows")Integer rows);
	//详情查询
	ProductInfo queryById(String productId);
	//分类查询
	Integer queryTypeTotal();
	List<ProductSort> queryByType(@Param("start")Integer start, @Param("rows")Integer rows);
}
