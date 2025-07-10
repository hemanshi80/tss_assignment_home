package com.tss.exception;

public class OverDraftReachedLimitException extends RuntimeException{

	private double overDraftLimit;

	public OverDraftReachedLimitException(double overDraftLimit) {
		super();
		this.overDraftLimit = overDraftLimit;
	}
	
	public String getMessage() {
		return "OverDraft Limit Reached " + overDraftLimit;
	}
}
