/**
 * Клас, який представляє замовлення з ідентифікатором та датою.
 */
public class Order {
    @XmlField("order_id")
    @JsonField("id")
    private int id;

    @XmlField("order_date")
    @JsonField("date")
    private String date;

    public Order(int id, String date) {
        this.id = id;
        this.date = date;
    }

    // Геттери
    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }
}
