package com.tss.behavioural.strategy.model;

public class SeniorConsultant implements IRole {
	@Override
	public String description() {
	return "Senior Consultant";
	}

	@Override
	public String responsibility() {
	    return "review code";
	}
}
