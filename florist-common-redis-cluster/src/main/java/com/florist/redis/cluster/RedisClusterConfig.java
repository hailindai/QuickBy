package com.florist.redis.cluster;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

@Configuration
@ConfigurationProperties("spring.redis.cluster")
public class RedisClusterConfig {
	private List<String> nodes;
	private Integer maxTotal;
	private Integer maxIdle;
	private Integer minIdle;
	
	@Bean
	public JedisCluster initJedisCluster(){
		Set<HostAndPort> clusterSet=new HashSet<>();
		for(String node:nodes){
			String host = node.split(":")[0];
			Integer port = Integer.parseInt(node.split(":")[1]);
			clusterSet.add(new HostAndPort(host, port));
		}
		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		config.setMaxTotal(maxTotal);
		config.setMaxIdle(8);
		config.setMinIdle(2);
		JedisCluster cluster = new JedisCluster(clusterSet,config);
		return cluster;
	}
	
	//可以用lombok简化javabean代码
	public List<String> getNodes() {
		return nodes;
	}
	public void setNodes(List<String> nodes) {
		this.nodes = nodes;
	}
	public Integer getMaxTotal() {
		return maxTotal;
	}
	public void setMaxTotal(Integer maxTotal) {
		this.maxTotal = maxTotal;
	}
	public Integer getMaxIdle() {
		return maxIdle;
	}
	public void setMaxIdle(Integer maxIdle) {
		this.maxIdle = maxIdle;
	}
	public Integer getMinIdle() {
		return minIdle;
	}
	public void setMinIdle(Integer minIdle) {
		this.minIdle = minIdle;
	}
	
}
