package com.example.demo.parrot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

import java.util.concurrent.ThreadLocalRandom

@SpringBootApplication
@RestController
class ParrotServiceApplication {

	static void main(String[] args) {
		SpringApplication.run ParrotServiceApplication, args
	}

	@RequestMapping(value = '/fee', method = RequestMethod.GET)
	def fee(){
		return [parrot_fee: ThreadLocalRandom.current().nextInt(100)]
	}
}
