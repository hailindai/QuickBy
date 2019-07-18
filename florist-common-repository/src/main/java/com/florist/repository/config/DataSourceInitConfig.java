package com.florist.repository.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DataSourceInitConfig {
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	private Integer maxActive;
	private Integer maxIdle;
	private Integer initialSize;
	private Integer minIdle;
	
	@Bean
	@Primary //当容器出现多个同类对象，以这个优先
	public DataSource initDruidDataSource(){
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		//连接池初始化参数，初始化连接数5个,剩3，每次+8，直到200封顶
		dataSource.setInitialSize(initialSize);//5 
		dataSource.setMaxActive(maxActive);//200
		dataSource.setMaxIdle(maxIdle);//8 
		dataSource.setMinIdle(minIdle);//3 
		return dataSource;
	}
	
	public String getDriverClassName() {
		return driverClassName;
	}
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getMaxActive() {
		return maxActive;
	}
	public void setMaxActive(Integer maxActive) {
		this.maxActive = maxActive;
	}
	public Integer getMaxIdle() {
		return maxIdle;
	}
	public void setMaxIdle(Integer maxIdle) {
		this.maxIdle = maxIdle;
	}
	public Integer getInitialSize() {
		return initialSize;
	}
	public void setInitialSize(Integer initialSize) {
		this.initialSize = initialSize;
	}
	public Integer getMinIdle() {
		return minIdle;
	}
	public void setMinIdle(Integer minIdle) {
		this.minIdle = minIdle;
	}
}
