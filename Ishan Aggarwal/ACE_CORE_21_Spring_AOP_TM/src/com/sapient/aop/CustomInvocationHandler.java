package com.sapient.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
	Object targetObject;

	public CustomInvocationHandler(Object targetObject) {
		this.targetObject = targetObject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result;
		AspectProcessor.preProcess();
		System.out.println("Method: " + method.getName());
		System.out.println("Args : " + args);
		result = method.invoke(targetObject, args);
		AspectProcessor.postProcess();
		return result;
	}

}
