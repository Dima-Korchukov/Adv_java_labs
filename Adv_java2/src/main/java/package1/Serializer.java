import java.lang.reflect.Field;

/**
 * Клас для серіалізації об'єктів у форматах XML та JSON за допомогою рефлексії.
 * Використовує анотації {@link XmlField} і {@link JsonField} для визначення мапінгу полів.
 */
public class Serializer {

    /**
     * Серіалізує об'єкт в формат XML.
     * Процес серіалізації використовує анотації {@link XmlField} для визначення назв тегів.
     * 
     * @param obj об'єкт, який потрібно серіалізувати.
     * @return рядок, що представляє об'єкт у форматі XML.
     * @throws IllegalAccessException якщо доступ до поля об'єкта обмежений.
     */
    public static String toXml(Object obj) throws IllegalAccessException {
        StringBuilder xmlBuilder = new StringBuilder();
        Class<?> clazz = obj.getClass();
        xmlBuilder.append("<").append(clazz.getSimpleName()).append(">\n");
        
        // Обробка всіх полів класу
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);  // Дозвіл доступу до приватних полів
            if (field.isAnnotationPresent(XmlField.class)) {
                String tagName = field.getAnnotation(XmlField.class).value();  // Отримання імені тега з анотації
                Object value = field.get(obj);  // Отримання значення поля
                xmlBuilder.append("\t<").append(tagName).append(">")
                          .append(value)
                          .append("</").append(tagName).append(">\n");
            }
        }
        
        xmlBuilder.append("</").append(clazz.getSimpleName()).append(">");
        return xmlBuilder.toString();
    }

    /**
     * Серіалізує об'єкт в формат JSON.
     * Процес серіалізації використовує анотації {@link JsonField} для визначення імен полів у JSON.
     * 
     * @param obj об'єкт, який потрібно серіалізувати.
     * @return рядок, що представляє об'єкт у форматі JSON.
     * @throws IllegalAccessException якщо доступ до поля об'єкта обмежений.
     */
    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder jsonBuilder = new StringBuilder();
        Class<?> clazz = obj.getClass();
        jsonBuilder.append("{\n");
        
        // Обробка всіх полів класу
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);  // Дозвіл доступу до приватних полів
            if (field.isAnnotationPresent(JsonField.class)) {
                String key = field.getAnnotation(JsonField.class).value();  // Отримання імені ключа з анотації
                Object value = field.get(obj);  // Отримання значення поля
                jsonBuilder.append("\t\"").append(key).append("\": \"").append(value).append("\"");
                
                // Додавання коми після кожного поля, крім останнього
                if (i < fields.length - 1) {
                    jsonBuilder.append(",");
                }
                jsonBuilder.append("\n");
            }
        }
        
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}
