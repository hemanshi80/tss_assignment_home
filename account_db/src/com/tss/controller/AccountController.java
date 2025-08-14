package com.tss.controller;

import java.util.Scanner;

import com.tss.service.AccountService;

public class AccountController {

	private AccountService accountService;

    public AccountController() {
        this.accountService = new AccountService();
    }

    public void startTransferFlow() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Fund Transfer Portal =====");

        System.out.print("Enter Sender Account ID: ");
        int senderId = scanner.nextInt();

        System.out.print("Enter Receiver Account ID: ");
        int receiverId = scanner.nextInt();

        System.out.print("Enter Amount to Transfer: ");
        double amount = scanner.nextDouble();

        accountService.transferFunds(senderId, receiverId, amount);

        System.out.println("================================");

        scanner.close();
    }
	
}
