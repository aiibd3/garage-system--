package parking;

public class PayPal implements Payment {
    private int cost;

    @Override
    public int pay(Duration total, int cost) {

        return (total.totalHours() * cost);
    }
}
