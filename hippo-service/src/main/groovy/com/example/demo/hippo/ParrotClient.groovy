package com.example.demo.hippo

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient("parrot-service")
interface ParrotClient {
    @RequestMapping(value = "/fee", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    ParrotClient.ParrotResponse getFee()

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class ParrotResponse {
        @JsonProperty("parrot_fee")
        private int parrotFee
    }
}
