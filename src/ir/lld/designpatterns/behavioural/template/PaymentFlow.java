package ir.lld.designpatterns.behavioural.template;

public abstract class PaymentFlow {
    public abstract void validateRequest();
    public abstract void calculateFees();
    public abstract void debitAmount();
    public abstract void creditAmount();

    // this is Template method: which defines the order of steps to execute the task.
    public final void sendMoney(){
        // step1
        validateRequest();

        // step2
        calculateFees();

        // step3
        debitAmount();

        // step4
        creditAmount();
    }
}
