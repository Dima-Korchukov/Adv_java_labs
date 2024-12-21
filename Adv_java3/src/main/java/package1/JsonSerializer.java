import java.lang.reflect.Field;

/**
 * The JsonSerializer class provides functionality to serialize objects into JSON format.
 * It uses reflection to access the fields of the object and serialize them with appropriate JSON keys and values.
 */
public class JsonSerializer {

    /**
     * Serializes the given object into a JSON string representation.
     * It uses the {@link SerializedName} annotation to map field names to JSON keys.
     *
     * @param obj the object to be serialized
     * @return a string containing the JSON representation of the object
     * @throws IllegalAccessException if the field cannot be accessed
     */
    public static String serializeToJson(Object obj) throws IllegalAccessException {
        StringBuilder json = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            SerializedName annotation = field.getAnnotation(SerializedName.class);
            String key = (annotation != null) ? annotation.value() : field.getName();
            Object value = field.get(obj);
            json.append(String.format("\"%s\":\"%s\",", key, escapeJson(value)));
        }
        // Remove trailing comma if present
        if (json.charAt(json.length() - 1) == ',') {
            json.deleteCharAt(json.length() - 1);
        }
        json.append("}");
        return json.toString();
    }

    /**
     * Escapes special characters in the JSON value (such as quotes and backslashes).
     *
     * @param value the value to be escaped
     * @return the escaped string
     */
    private static String escapeJson(Object value) {
        return value.toString()
            .replace("\"", "\\\"")
            .replace("\\", "\\\\");
    }
}
