package com.tss.behavioural.strategy.model;

public class Consultant implements IRole {
	@Override
	public String description() {
	return "Consultant";
	}

	@Override
	public String responsibility() {
	    return "write code";
	}
}
