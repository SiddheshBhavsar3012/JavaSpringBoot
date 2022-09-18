package com.example.config;

import java.util.Date;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.example.entity.AuditLog;
import com.example.entity.User;
import com.example.repository.AuditLogRepository;
import com.example.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@Aspect

public class AspectConfig {
	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	AuditLogRepository auditLogRepository;
	
//	// Pointcut expression acessModifier return type pacakageName.classname.methodName(..)
//	@Before("execution(public * com.example.service.*.*(..)	)")
//	public void logBeforeAllMethods(JoinPoint joinpoint) {
//		log.info(joinpoint.getSignature().getName()+" started");
//	}
//	
//	@After("execution(public * com.example.service.*.*(..)	)")
//	public void logAfter(JoinPoint joinPoint) {
//		log.info(joinPoint.getSignature()+" Ended");
//	}
	
//	@Around("execution(public * com.example.service.*.*(..)	)")
//	public void logBeforeAndAfter(ProceedingJoinPoint joinPoint) throws Throwable {
//		log.info(joinPoint.getSignature()+" Started");
//		joinPoint.proceed();
//		log.info(joinPoint.getSignature()+" Ended");
//	}
	
	@AfterReturning("execution(public * com.example.service.UserServiceImpl.addUser(..)	)")
	public void logBeforeAddUser(JoinPoint joinPoint) {
		
		auditLogRepository.saveAndFlush(AuditLog.builder().createDate(new Date()).description("A user added " +joinPoint.getArgs()[0]).build());
		
	}
	
//	@AfterThrowing("execution(public * com.example.service.UserServiceImpl.updateUser(..)	)")
//	public void afterThrowing( JoinPoint joinPoint ) {
//		User us=(User)joinPoint.getArgs()[0];
//		auditLogRepository.saveAndFlush(AuditLog.builder().createDate(new Date()).description("error while updating user "+us.getId()).build());
//	}
}
