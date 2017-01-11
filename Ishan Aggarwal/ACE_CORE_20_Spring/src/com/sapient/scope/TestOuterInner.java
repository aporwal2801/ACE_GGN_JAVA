package com.sapient.scope;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOuterInner {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Beans.xml");
		Inner inner = context.getBean(Inner.class);
		Inner inner1 = context.getBean(Inner.class);

		Outer outer = context.getBean(Outer.class);
		System.out.println(outer);
		System.out.println(inner);
		System.out.println(inner1);

		System.out.println("inner1 : " + inner1.hashCode());
		System.out.println("inner : " + inner.hashCode());

		Outer outer1 = context.getBean(Outer.class);

		System.out.println("outer1 : " + outer1.hashCode());
		System.out.println("outer : " + outer.hashCode());

		outer.setOuterInteger(50);

		System.out.println("outer1.getOuterInteger : "
				+ outer1.getOuterInteger());

		inner.setInnerInteger(2005);

		System.out
				.println("inner.getInnerInteger : " + inner.getInnerInteger());
		System.out.println("inner1.getInnerInteger : "
				+ inner1.getInnerInteger());

		ApplicationContext context1 = new ClassPathXmlApplicationContext(
				"Beans.xml");

		Outer outer2 = context1.getBean(Outer.class);
		System.out.println("outer2 : " + outer2.hashCode());

	}

}
