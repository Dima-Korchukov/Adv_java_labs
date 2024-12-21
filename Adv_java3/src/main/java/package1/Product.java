public class Product {
    @SerializedName("product_id")
    private int id;

    @SerializedName("product_name")
    private String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns the product ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the product name.
     */
    public String getName() {
        return name;
    }
}
