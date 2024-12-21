/**
 * The UserSQLGenerator class provides functionality to generate SQL queries for {@link User} objects.
 * Specifically, it generates an SQL insert query for a user.
 */
public class UserSQLGenerator {

    /**
     * Generates an SQL INSERT query for a given {@link User}.
     *
     * @param user the {@link User} object to generate the query for
     * @return the generated SQL INSERT query as a string
     */
    public static String generateInsertQuery(User user) {
        return String.format(
            "INSERT INTO users (user_id, user_name) VALUES (%d, '%s');",
            user.getId(),
            user.getName()
        );
    }
}
