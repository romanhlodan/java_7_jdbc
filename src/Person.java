import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private int age;
    private String e_mail;
    private int sum;
    private String currency;

    public Person() {
    }

    public Person(int id, String name, int age, String e_mail, int sum, String currency) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.e_mail = e_mail;
        this.sum = sum;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                age == person.age &&
                sum == person.sum &&
                name.equals(person.name) &&
                e_mail.equals(person.e_mail) &&
                currency.equals(person.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, e_mail, sum, currency);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", e_mail='" + e_mail + '\'' +
                ", sum=" + sum +
                ", currency=" + currency +
                '}';
    }
}
