/**
 * The ProductSQLGenerator class provides functionality to generate SQL queries for {@link Product} objects.
 * Specifically, it generates an SQL insert query for a product.
 */
public class ProductSQLGenerator {

    /**
     * Generates an SQL INSERT query for a given {@link Product}.
     *
     * @param product the {@link Product} object to generate the query for
     * @return the generated SQL INSERT query as a string
     */
    public static String generateInsertQuery(Product product) {
        return String.format(
            "INSERT INTO products (product_id, product_name) VALUES (%d, '%s');",
            product.getId(),
            product.getName()
        );
    }
}
