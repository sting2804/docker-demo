package com.example.demo.hippo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import java.util.concurrent.atomic.AtomicInteger

@SpringBootApplication
@RestController
@EnableFeignClients
class HippoServiceApplication {

	static void main(String[] args) {
		SpringApplication.run HippoServiceApplication, args
	}

	@Autowired
	ParrotClient parrotClient

	private AtomicInteger hippoCount = new AtomicInteger(Integer.MAX_VALUE)

	@RequestMapping(value = '/rent', method = RequestMethod.GET)
	def rent(@RequestParam Optional<Integer> count){
		def feeResp  = parrotClient.getFee()
		def remain = hippoCount.addAndGet(-count.orElse(-1))
		return [hippoRemail: remain, fee: feeResp]
	}
}
