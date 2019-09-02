package com.torres.aspect;

import org.apache.log4j.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	// Setup Logger - avoid sending different messages to different Streams (messages order)
	// System.out.print and Spring send messages to a different Streams without synchronised order
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// Setup Pointcut Declaration for the controller Package
	@Pointcut("execution(* com.torres.controller.*.*(..))")
	private void controllerPackagePointcut() {}
	
	// Setup Pointcut Declaration for the service Package
	@Pointcut("execution(* com.torres.service.*.*(..))")
	private void servicePackagePointcut() {}
	
	// Setup Pointcut Declaration for the db Package
	@Pointcut("execution(* com.torres.db.*.*(..))")
	private void dbPackagePointcut() {}
	
	// Setup Combined Pointcut
	@Pointcut("controllerPackagePointcut() || servicePackagePointcut() || dbPackagePointcut()")
	private void combinedPackagesPointcut() {}
	
	// Add @Before Advice
	@Before("combinedPackagesPointcut()")
	public void beforeAOPAdvice(JoinPoint joinPoint) {
		// Display the method being called
		logger.info("######################################## Method @Before: " + joinPoint.getSignature().toShortString());
		
		// Get the Arguments and display them
		Object [] arguments = joinPoint.getArgs();
		
		for (Object argument : arguments) {
			logger.info("######################################## Arguments @Before: " + argument);
		}
	}
	
	// Add @AfterReturrning Advice
	@AfterReturning(pointcut = "combinedPackagesPointcut()", returning = "result")
	public void afterReturningAOPAdvice(JoinPoint joinPoint, Object result) {
		// Display the method we are returning from
		logger.info("* * * * * * * * * * * * * * * * * * * * @AfterReturning from: " + joinPoint.getSignature().toShortString());
		
		// Display the Result from the method
		logger.info("* * * * * * * * * * * * * * * * * * * * @AfterReturning Result: " + result);
	}
}
