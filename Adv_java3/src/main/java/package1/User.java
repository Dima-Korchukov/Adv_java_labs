/**
 * Represents a User entity.
 */
public class User {
    @SerializedName("user_id")
    private int id;

    @SerializedName("user_name")
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns the user ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the user name.
     */
    public String getName() {
        return name;
    }
}
