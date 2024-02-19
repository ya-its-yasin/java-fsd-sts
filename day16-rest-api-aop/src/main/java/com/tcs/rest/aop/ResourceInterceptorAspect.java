package com.tcs.rest.aop;

import java.util.Optional;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.tcs.rest.resource.Product;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ResourceInterceptorAspect {

	@Pointcut("execution(* com.tcs.rest.resources.*.*(..))")
	public void loggingPointCut(){}
	
	@Before("loggingPointCut()")
	public void before(JoinPoint joinPoint)
	{
		log.info("Before method invoked ::" + joinPoint.getSignature());
	}
	
	@After("loggingPointCut()")
	public void after(JoinPoint joinPoint)
	{
		log.info("After method invoked ::" + joinPoint.getSignature());
	}
	
	@AfterReturning(value="execution(* com.tcs.rest.resources.*.*(..))", returning = "op")
	public void afterReturn(JoinPoint jp, Optional<Product> op)
	{
		log.info("After returning method invoked ::" + op.get());
	}
	
	@AfterThrowing(value="execution(* com.tcs.rest.resources.*.*(..))", throwing = "e")
	public void afterThrow(JoinPoint jp, Exception e)
	{
		log.info("After returning method invoked ::" + e);
	}
	
	@Around("loggingPointCut()")
	public Object around(ProceedingJoinPoint jp) throws Throwable
	{
		log.info("Before method invoked:: " + jp.getSignature() + "\n" + jp.getArgs());
		Object obj = jp.proceed();
		if(obj instanceof Product)
			log.info("After method invoked.." + jp.getSignature());
		return obj;
	}
	
}
