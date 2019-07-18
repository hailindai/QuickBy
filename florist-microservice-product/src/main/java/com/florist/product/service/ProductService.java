package com.florist.product.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.florist.common.pojo.ProductInfo;
import com.florist.common.pojo.ProductSort;
import com.florist.common.utils.MapperUtil;
import com.florist.common.vo.ProductInfoUIResult;
import com.florist.common.vo.ProductSortUIResult;
import com.florist.product.mapper.ProductMapper;

@Service
public class ProductService {
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private TransportClient client;
	//分页查询
	public ProductInfoUIResult productPageQuery(Integer page, Integer rows) {
		ProductInfoUIResult result = new ProductInfoUIResult();
		Integer total = productMapper.queryTotal();
		Integer start = (page - 1) * rows;
		List<ProductInfo> pList = productMapper.queryByPage(start, rows);
		result.setTotal(total);
		result.setRows(pList);
		return result;
	}

	//详情查询
	public ProductInfo queryById(String productId) {
		return productMapper.queryById(productId);
	}
	//分类查询
	public ProductSortUIResult productTypeQuery(Integer page, Integer rows) {
		ProductSortUIResult result = new ProductSortUIResult();
		Integer total = productMapper.queryTypeTotal();
		Integer start = (page - 1) * rows;
		List<ProductSort> tList = productMapper.queryByType(start, rows);
		result.setTotal(total);
		result.setRows(tList);
		return result;
	}

	public ProductInfoUIResult searchBySortName(String sortName, Integer page, Integer rows) {
		ProductInfoUIResult result = new ProductInfoUIResult();
		List<ProductInfo> pList = search("sortName",sortName,page, rows);
		result.setTotal(pList.size());
		result.setRows(pList);
		return result;
	}
	
	private List<ProductInfo> search(String key,String sortName, Integer page, Integer rows){
		
		MatchQueryBuilder matchQuery = QueryBuilders.matchQuery(key, sortName);
		SearchResponse response = client.prepareSearch("floindex").setQuery(matchQuery).setFrom((page-1)*rows).setSize(rows).get();
		SearchHits hits = response.getHits();
		System.out.println("一共搜索：" + hits.getTotalHits() + "条");
		try {
			SearchHit[] hit = hits.getHits();
			List<ProductInfo> pList = new ArrayList<>();
			for(SearchHit searchHit:hit){
				String pJson = searchHit.getSourceAsString();
				ProductInfo product = MapperUtil.MP.readValue(pJson, ProductInfo.class);
				pList.add(product);
			}
			return pList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private List<ProductInfo> search(String key1,String name1,String key2,Integer start, Integer end, Integer page, Integer rows){
		
		MatchQueryBuilder matchQuery = QueryBuilders.matchQuery(key1, name1);
		RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery(key2).from(start).to(end);
		QueryBuilder qb3 = null;
		System.out.println("es search: productName:"+name1);
		System.out.println("es search: startPrice:"+start);
		System.out.println("es search: endPrice:"+end);
		if(!StringUtils.isEmpty(name1)){//如果没有输入商品名称
			qb3 = QueryBuilders.boolQuery().must(matchQuery).must(rangeQueryBuilder);
		}else {
			qb3 = QueryBuilders.boolQuery().must(rangeQueryBuilder);
		}
				
		SearchResponse response =client.prepareSearch("floindex").setQuery(qb3).setFrom((page-1)*rows).setSize(rows).get();
		SearchHits hits = response.getHits();
		System.out.println("一共搜索：" + hits.getTotalHits() + "条");
		try {
			SearchHit[] hit = hits.getHits();
			List<ProductInfo> pList = new ArrayList<>();
			for(SearchHit searchHit:hit){
				String pJson = searchHit.getSourceAsString();
				ProductInfo product = MapperUtil.MP.readValue(pJson, ProductInfo.class);
				pList.add(product);
			}
			return pList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ProductInfoUIResult searchByProductNameAndPrice(String productName,Integer startPrice, Integer endPrice, Integer page,
			Integer rows) {
		ProductInfoUIResult result = new ProductInfoUIResult();
		List<ProductInfo> pList = search("productName",productName,"productPrice",startPrice,endPrice,page, rows);
		result.setTotal(pList.size());
		result.setRows(pList);
		return result;
	}
	
	public void create() {
		// 读取商品数据
		List<ProductInfo> pList = productMapper.queryByPage(0,1000);
		// 将数据存储到floindex索引文件
		for (ProductInfo product : pList) {
			String json;
			try {
				json = MapperUtil.MP.writeValueAsString(product);
				IndexRequestBuilder request = client.prepareIndex("floindex", "product", product.getProductId().toString());
				request.setSource(json).get();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
