package com.tlf.creatorconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;


import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class CreatorconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreatorconsumerApplication.class, args);
	}


	@Autowired
	private CubeSpaceConfig cubeSpaceConfig;

	@Bean
	public SimpleClientHttpRequestFactory httpClientFactory() {
		SimpleClientHttpRequestFactory httpRequestFactory = new SimpleClientHttpRequestFactory();
		httpRequestFactory.setReadTimeout(cubeSpaceConfig.getRestReadTimeout());
		httpRequestFactory.setConnectTimeout(cubeSpaceConfig.getRestConnectTimeout());


		return httpRequestFactory;
	}

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(SimpleClientHttpRequestFactory httpClientFactory) {
		RestTemplate restTemplate = new RestTemplate(httpClientFactory);
		return restTemplate;
	}
}
