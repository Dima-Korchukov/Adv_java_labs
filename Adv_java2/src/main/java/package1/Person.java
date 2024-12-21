/**
 * Клас, який представляє людину з ім'ям та віком.
 */
public class Person {
    @XmlField("full_name")
    @JsonField("name")
    private String name;

    @XmlField("age_years")
    @JsonField("age")
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Геттери для серіалізації
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
