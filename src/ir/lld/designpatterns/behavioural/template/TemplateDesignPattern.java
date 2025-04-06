package ir.lld.designpatterns.behavioural.template;

public class TemplateDesignPattern {
    public static void main(String[] args) {
        PaymentFlow friendFlow = new PayToFriend();
        PaymentFlow merchantFlow = new PayToMerchant();

        friendFlow.sendMoney();
        merchantFlow.sendMoney();
    }
}
