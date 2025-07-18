package com.tss.behavioural.strategy.model;

public class TechLead  implements IRole {
	@Override
	public String description() {
	return "Tech Lead";
	}
	
	@Override
	public String responsibility() {
	    return "assign work";
	}

}
