package com.sapient.spring.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CustomerAspect {

//	@Before("execution(public com.sap.practise.bean.Customer com.sape.practise.aop.CustomerServiceImpl.getCustomerById(*))")
//	public void beforeGetCustomerId(){
//		System.out.println("Executing before Advice on getCustomerById()");
//	}
//	
//	@Before("execution(* com.sape.practise.aop.CustomerServiceImpl.*(*))")
//	public void beforeAllMethods(){
//		System.out.println("Executing before Advise for all methods");
//	}
//	
	@After("execution(public com.sap.practise.bean.Customer com.sape.practise.aop.CustomerServiceImpl.getCustomerById(*))")
	public void afterGetCustomerId(){
		System.out.println("Executing after Advice on getCustomerById()");
	}
//	
//	@After("execution(* com.sape.practise.aop.CustomerServiceImpl.*(*))")
//	public void afterAllMethods(){
//		System.out.println("Executing after Advise for all methods");
//	}
	
//	@Before("args(id)")
//	public void beforeAllMethodwhichtakesIntArgument(int id){
//		System.out.println("Method call before a method with int argument");
//	}
	
	@Before("allMethodsPointcut()")
	public void loggingAdvice(JoinPoint joinPoint){
		System.out.println("Before running loggingAdvice on method="+joinPoint.toString());
		
		System.out.println("Agruments Passed=" + Arrays.toString(joinPoint.getArgs()));

	}
	
	@Before("@annotation(java.beans.Transient)")
	public void myAdvice(){
		System.out.println("Executing myAdvice!!");
	}
	
//	@AfterReturning(pointcut="execution(public com.sap.practise.bean.Customer com.sape.practise.aop.CustomerServiceImpl.getCustomerById(*))", returning="returnedResult")
//	public void getNameReturningAdvice(Customer returnedResult){
//		System.out.println("getNameReturningAdvice executed. Returned String="+returnedResult);
//	}
	
//	@After("allMethodsPointcut()")
//	public void afterAllMethodUsingNamedPointCut(){
//		System.out.println("Method call after each method using named pointcut");
//	}
	
	@Pointcut("execution(* com.sape.practise.aop.CustomerServiceImpl.*(*))")
	public void allMethodsPointcut(){}
}
