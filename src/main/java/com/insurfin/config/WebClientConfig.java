//package com.insurfin.config;
//
//import com.insurfin.client.UserClient;
//import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.oauth2.server.resource.web.reactive.function.client.ServletBearerExchangeFilterFunction;
//import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.reactive.function.client.support.WebClientAdapter;
//import org.springframework.web.service.invoker.HttpServiceProxyFactory;
//
//
//
//@Configuration
//public interface WebClientConfig {
//
//    private final LoadBalancedExchangeFilterFunction filterFunction;
//
//    @Bean
//    public WebClient userWebClient() {
//        return WebClient.builder().baseUrl("http://localhost:8080").filter(filterFunction).filter(new ServletBearerExchangeFilterFunction()).build();
//    }
//
//
//    @Bean
//    public default UserClient userClient() {
//        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(userWebClient())).build();
//        return httpServiceProxyFactory.createClient(UserClient.class);
//    }
//}
