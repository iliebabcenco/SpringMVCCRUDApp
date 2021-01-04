package md.babcenco.springcourse.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Person {
    private static int ID_COUNTER;
    private int id;
    @NotEmpty(message="Name should not be empty")
    @Size(min = 2, max = 30, message="Name should be between 2 and 30 characters")
    private String name;
    @NotEmpty(message="Surname should not be empty")
    private String surname;
    @Min(value=16, message="age should be greater than 16")
    @Max(value=150, message="age should be less than 16")
    private int age;
    @NotEmpty(message="Name should not be empty")
    @Email(message = "Email. should be valid")
    private String email;

    public Person(String name, String surname, int age, String email) {
        this.id = ++ID_COUNTER;
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
