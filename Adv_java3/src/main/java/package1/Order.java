public class Order {
    @SerializedName("order_id")
    private int id;

    @SerializedName("order_amount")
    private double amount;

    public Order(int id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * Returns the order ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the order amount.
     */
    public double getAmount() {
        return amount;
    }
}
