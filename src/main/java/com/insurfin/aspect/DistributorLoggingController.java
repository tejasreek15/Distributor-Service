package com.insurfin.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Component
@Aspect
@Slf4j
public class DistributorLoggingController {

	Logger logger = LoggerFactory.getLogger(DistributorLoggingController.class);

	@Before(value = "execution(* com.insurfin.controller.*.*(..)) || "
			+ "execution(* com.insurfin.serviceImpl.*.*(..))")
	public void before(JoinPoint joinpoint) {
		logger.info("Before execution of{}", joinpoint.getSignature());
	}

	@AfterThrowing(value = "execution (* com.insurfin.controller.*.*(..)) || "
			+ "execution(* com.insurfin.serviceImpl.*.*(..))", throwing = "error")
	public void afterThrowing(JoinPoint joinPoint, Throwable error) {
		logger.error("Method Signature: " + joinPoint.getSignature());
	}

	@After(value = "execution(* com.insurfin.controller.*.*(..))")
	public void after(JoinPoint joinpoint) {
		logger.info("After execution of{}", joinpoint.getSignature());
	}

	@AfterReturning(value = "execution(* com.insurfin.controller.*.*(..))", returning = "result")
	public void afterReturningController(JoinPoint joinPoint, Object result) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (result != null) {
				Object json = mapper.readValue(mapper.writeValueAsString(result), Object.class);
				logger.debug("Method Signature:" + joinPoint.getSignature());
				logger.info("Finale response in Controller{}", mapper.writeValueAsString(json.toString()));
			} else {
				logger.info("Response is Empty!");
			}

		} catch (JsonProcessingException e) {
			logger.error("", e);
		}
	}

	@AfterReturning(value = "execution(* com.insurfin.serviceImpl.*.*(..))", returning = "result")
	public void afterReturningService(JoinPoint joinPoint, Object result) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (result != null) {
				Object json = mapper.readValue(mapper.writeValueAsString(result), Object.class);
				logger.debug("Method Signature in Service:" + joinPoint.getSignature());
				logger.info("Final response in Service{}", mapper.writeValueAsString(json.toString()));
			} else {
				logger.info("Response is Empty!");
			}

		} catch (JsonProcessingException e) {
			logger.error("", e);
		}
	}

}
