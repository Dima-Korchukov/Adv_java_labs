/**
 * The OrderSQLGenerator class provides functionality to generate SQL queries for {@link Order} objects.
 * Specifically, it generates an SQL insert query for an order.
 */
public class OrderSQLGenerator {

    /**
     * Generates an SQL INSERT query for a given {@link Order}.
     *
     * @param order the {@link Order} object to generate the query for
     * @return the generated SQL INSERT query as a string
     */
    public static String generateInsertQuery(Order order) {
        return String.format(
            "INSERT INTO orders (order_id, order_amount) VALUES (%d, %.2f);",
            order.getId(),
            order.getAmount()
        );
    }
}
