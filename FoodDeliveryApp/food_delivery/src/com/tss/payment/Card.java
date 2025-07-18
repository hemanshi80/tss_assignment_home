package com.tss.payment;

public class Card implements IPayment {

    private static final long serialVersionUID = 1L;
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;

    public Card(String cardNumber, String cardHolderName, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Payment successful of amount " + amount +" via Card ending with " + cardNumber.substring(cardNumber.length() - 4));
        return true;
    }

    @Override
    public String getPaymentMode() {
        return "Card";
    }
    
    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
}