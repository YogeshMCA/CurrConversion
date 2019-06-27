package com.example.microservices.Zipkin.ZipkinLogging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

import zipkin.server.internal.EnableZipkinServer;


@SpringBootApplication
@EnableZipkinServer
@EnableDiscoveryClient
public class ZipkinLoggingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinLoggingApplication.class, args);
	}

	@Bean
	public AlwaysSampler alwaysSampler() {
		return new AlwaysSampler();
	}
}
