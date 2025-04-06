package ir.lld.designpatterns.behavioural.template;

public class PayToFriend extends PaymentFlow{
    @Override
    public void validateRequest() {
        // specific validation for payment to friend flow
        System.out.println("Validate logic of PayToFriend");
    }

    @Override
    public void calculateFees() {
        // calculate the fees
        System.out.println("0% fees charged");
    }

    @Override
    public void debitAmount() {
        // debit the amount
        System.out.println("Debit the amount logic of PayToFriend");
    }

    @Override
    public void creditAmount() {
        // credit the amount
        System.out.println("Credit the amount logic of PayToFriend");
    }
}
