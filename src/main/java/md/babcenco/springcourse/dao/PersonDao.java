package md.babcenco.springcourse.dao;

import md.babcenco.springcourse.models.Person;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDao {
    private static List<Person> people;

    static {
        people = new ArrayList<>();
        people.add(new Person("Hiuri","Aiusea", "hiuri_aiusea@gmail.com"));
        people.add(new Person("Virtosu","Denis", "virtden@gmail.com"));
        people.add(new Person("Miroslav","Chiucamber", "miroslavchiur@gmail.com"));
        people.add(new Person("Aiva","Andrei", "aiva_andrei@gmail.com"));
        people.add(new Person("Mentalist","Chirlam", "mentalist@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person showPerson(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void addPerson(Person person) {

        people.add(person);
    }

    public void update(int id, Person person) {
        //Person persontToBeUpdated = showPerson(id);
        for (Person pers:
             people) {
            if(id == pers.getId()) {
                people.set(people.indexOf(pers), person);
            }
        }
    }
    public void delete(int id) {
        Person persontToBeDeleted = showPerson(id);
        people.remove(persontToBeDeleted);
    }
}
