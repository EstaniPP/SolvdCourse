package com.solvd.carFactory.genericsLambda;

import java.util.ArrayList;

@FunctionalInterface
public interface IOrderAndFilter<T,U> {

	void order(ArrayList<T> t, U u);

}
