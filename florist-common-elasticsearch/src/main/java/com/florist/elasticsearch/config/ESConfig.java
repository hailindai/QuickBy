package com.florist.elasticsearch.config;

import java.net.InetSocketAddress;
import java.util.List;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix="elasticsearch")
public class ESConfig {
	private List<String> nodes;
	
	@Bean
	public TransportClient initESTransportClient(){
		TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
		for(String node:nodes){
			String host = node.split(":")[0];
			Integer port = Integer.parseInt(node.split(":")[1]);
			client.addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress(host, port)));
		}
		return client;
	}

	public List<String> getNodes() {
		return nodes;
	}

	public void setNodes(List<String> nodes) {
		this.nodes = nodes;
	}
}
