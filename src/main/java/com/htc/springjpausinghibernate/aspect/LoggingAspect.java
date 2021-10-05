package com.htc.springjpausinghibernate.aspect;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	@Before("execution(* com.htc.springjpausinghibernate.dao.StudentDaoImplementation.*(..))")
	public void before(JoinPoint jointpoint) throws Throwable {	
		Log logger = LogFactory.getLog(jointpoint.getTarget().getClass());
		logger.info("Calling method- " + jointpoint.getSignature().getName());
		logger.info("Params:" + Arrays.toString(jointpoint.getArgs()));

		logger.info("-------------------------------------------------------------------");
	}
	
	@AfterReturning(pointcut="execution(* com.htc.springjpausinghibernate.dao.StudentDaoImplementation.*(..))", returning="retVal")
	public void afterReturning(JoinPoint jp, Object retVal) throws Throwable {
		Log logger = LogFactory.getLog(jp.getTarget().getClass());
		logger.info("Calling method- " + jp.getSignature().getName());
		logger.info("Params:" + Arrays.toString(jp.getArgs()));
		logger.info("Return value:" + retVal.toString());
		logger.info("-------------------------------------------------------------------");

	}
	
	@AfterThrowing(pointcut="execution(* com.htc.springjpausinghibernate.dao.StudentDaoImplementation.*(..))", throwing="ex")
	public void afterThrowing(JoinPoint jp, Exception ex) {

		Log logger = LogFactory.getLog(jp.getTarget().getClass());
		logger.info("Method- " + jp.getSignature().getName() + " Throws exception");

		logger.error("Error :" + ex.toString());
		logger.info("-------------------------------------------------------------------");
	}

}
