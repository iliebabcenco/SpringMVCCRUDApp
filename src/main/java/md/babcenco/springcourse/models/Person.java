package md.babcenco.springcourse.models;


public class Person {
    private static int ID_COUNTER;
    private int id;
    private String name;
    private String surname;
    private String email;

    public Person(String name, String surname, String email) {
        this.id = ++ID_COUNTER;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Person() {
        this.id = ++ID_COUNTER;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
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
}
