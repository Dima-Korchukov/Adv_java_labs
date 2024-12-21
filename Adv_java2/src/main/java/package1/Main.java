/**
 * Основний клас для демонстрації серіалізації об'єктів у форматах XML та JSON
 * з використанням рефлексії та статичних методів.
 */
public class Main {
    /**
     * Основний метод для тестування серіалізації об'єктів у формати XML та JSON.
     * Порівнюється час виконання серіалізації з рефлексією та без неї.
     * 
     * @param args аргументи командного рядка.
     * @throws IllegalAccessException якщо доступ до поля об'єкта обмежений.
     */
    public static void main(String[] args) throws IllegalAccessException {
        // Створення об'єктів для тестування серіалізації
        Person person = new Person("John Doe", 30);
        Product product = new Product("Laptop", 999.99);
        Order order = new Order(123, "2024-12-21");

        // Використання рефлексії для серіалізації
        long startReflexion = System.nanoTime();
        System.out.println(Serializer.toXml(person));   // Серіалізація в XML
        System.out.println(Serializer.toJson(person));  // Серіалізація в JSON
        System.out.println(Serializer.toXml(product));  // Серіалізація продукту в XML
        System.out.println(Serializer.toJson(product)); // Серіалізація продукту в JSON
        System.out.println(Serializer.toXml(order));    // Серіалізація замовлення в XML
        System.out.println(Serializer.toJson(order));   // Серіалізація замовлення в JSON
        long endReflexion = System.nanoTime();

        // Використання статичних методів для серіалізації
        long startStatic = System.nanoTime();
        System.out.println(StaticSerializer.toXml(person));   // Статична серіалізація в XML
        System.out.println(StaticSerializer.toJson(person));  // Статична серіалізація в JSON
        long endStatic = System.nanoTime();

        // Виведення часу виконання серіалізації з рефлексією та без
        System.out.println("Час із рефлексією: " + (endReflexion - startReflexion) + " нс");
        System.out.println("Час без рефлексії: " + (endStatic - startStatic) + " нс");
    }
}
