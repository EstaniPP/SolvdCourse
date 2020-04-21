package com.solvd.carFactory.genericsLambda;

@FunctionalInterface
public interface ICompare<T> {

	Boolean compare(T first, T second);
	
}
