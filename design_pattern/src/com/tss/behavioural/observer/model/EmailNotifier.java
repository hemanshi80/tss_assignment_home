package com.tss.behavioural.observer.model;

public class EmailNotifier implements INotifier {

	@Override
	public void sendNotification(String string, double amount) {
		System.out.println("Email send to :");
	}
}
