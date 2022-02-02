package M04_JavaOOP.L12_DesignPatterns.Lab.T03Template;

public abstract class TemplatePurchase {

    public final void purchaseOrder() {
        getItemsFromCart();
        calculatePricesWithDiscounts();
        createReceipt();
        payOrder();
        notifyClient();
    }

    protected abstract void getItemsFromCart();

    protected abstract void calculatePricesWithDiscounts();

    protected abstract void createReceipt();

    protected abstract void payOrder();

    protected abstract void notifyClient();
}