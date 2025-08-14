package com.tss.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;

import com.tss.dao.AccountDao;
import com.tss.model.Account;

public class AccountService {

	 private AccountDao accountDao;

	    public AccountService() {
	        this.accountDao = new AccountDao();
	    }

	    public void transferFunds(int senderId, int receiverId, double amount) {
	        if (senderId == receiverId) {
	            System.out.println("Sender and Receiver accounts must be different.");
	            return;
	        }

	        if (amount <= 0) {
	            System.out.println("Amount must be greater than zero.");
	            return;
	        }

	        Connection conn = accountDao.getConnection();
	        Savepoint savepoint = null;

	        try {
	            conn.setAutoCommit(false);

	            Account sender = accountDao.getAccountById(senderId);
	            if (sender == null) {
	                System.out.println("Sender account not found.");
	                return;
	            }

	            if (sender.getBalance() < amount) {
	                System.out.println("Insufficient balance.");
	                return;
	            }

	            accountDao.deductFromAccount(senderId, amount);

	            savepoint = conn.setSavepoint("AfterDebit");

	            int rows = accountDao.creditToAccount(receiverId, amount);
	            if (rows == 0) {
	                conn.rollback(savepoint);
	                conn.commit(); 
	                System.out.println("Receiver not found. Debit retained.");
	                return;
	            }

	            conn.commit();
	            System.out.println("Transfer successful!");

	        } catch (SQLException e) {
	            try {
	                if (savepoint != null) {
	                    conn.rollback(savepoint);
	                    conn.commit(); 
	                    System.out.println("Transfer failed during credit. Debit retained.");
	                } else {
	                    conn.rollback();
	                    System.out.println("Transfer failed completely. Full rollback.");
	                }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	            e.printStackTrace();
	        } finally {
	            try {
	                conn.setAutoCommit(true);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}
