package ir.lld.designpatterns.behavioural.template;

public class PayToMerchant extends PaymentFlow{
    @Override
    public void validateRequest() {
        // specific validation for payment to merchant flow
        System.out.println("Validate logic of PayToMerchant");
    }

    @Override
    public void calculateFees() {
        // calculate the fees
        System.out.println("2% fees charged for PayToMerchant");
    }

    @Override
    public void debitAmount() {
        // debit the amount
        System.out.println("Debit the amount logic of PayToMerchant");
    }

    @Override
    public void creditAmount() {
        // credit the amount
        System.out.println("Credit the remaining amount to PayToMerchant");
    }
}
