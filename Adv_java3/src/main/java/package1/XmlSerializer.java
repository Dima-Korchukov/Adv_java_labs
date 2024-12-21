import java.lang.reflect.Field;

/**
 * The XmlSerializer class provides functionality to serialize objects into XML format.
 * It uses reflection to access the fields of the object and serialize them with appropriate XML tags.
 */
public class XmlSerializer {

    /**
     * Serializes the given object into an XML string representation.
     * It uses the {@link SerializedName} annotation to map field names to XML tags.
     *
     * @param obj the object to be serialized
     * @return a string containing the XML representation of the object
     * @throws IllegalAccessException if the field cannot be accessed
     */
    public static String serializeToXml(Object obj) throws IllegalAccessException {
        StringBuilder xml = new StringBuilder("<object>");
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            SerializedName annotation = field.getAnnotation(SerializedName.class);
            String key = (annotation != null) ? annotation.value() : field.getName();
            Object value = field.get(obj);
            xml.append(String.format("<%s>%s</%s>", key, value, key));
        }
        xml.append("</object>");
        return xml.toString();
    }
}
