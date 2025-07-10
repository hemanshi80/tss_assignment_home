package com.tss.test.exception_handling;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectionTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class stringclass = Class.forName("java.lang.String");
		Method methods[] = stringclass.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName() + "\t" + method.getParameterCount());
			Parameter parameters[] = method.getParameters();
			for (Parameter parameter : parameters) {
				System.out.println(parameter.getName() + "\t" + parameter.getType());
			}
		}

		Constructor constructors[] = stringclass.getConstructors();
        for (Constructor c : constructors) {
        	if (c.getParameterCount() == 1 && c.getParameterTypes()[0] == String.class) {
                String s = (String) c.newInstance("Hello from Reflection!");
                System.out.println("Created String: " + s);
            }
        }
        }

		
	}


