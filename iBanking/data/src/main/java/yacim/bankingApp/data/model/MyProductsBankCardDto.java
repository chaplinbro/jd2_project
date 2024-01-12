package yacim.bankingApp.data.model;


public class MyProductsBankCardDto {

    private String cardNumber;

    private String cardholderName;

    private double cardBalance;

    private String cardCurrency;

    public MyProductsBankCardDto() {
    }

    public MyProductsBankCardDto(String cardNumber, String cardholderName, double card_balance, String cardCurrency) {
        this.cardNumber = cardNumber;
        this.cardholderName = cardholderName;
        this.cardBalance = card_balance;
        this.cardCurrency = cardCurrency;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public double getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }

    public String getCardCurrency() {
        return cardCurrency;
    }

    public void setCardCurrency(String cardCurrency) {
        this.cardCurrency = cardCurrency;
    }
}
