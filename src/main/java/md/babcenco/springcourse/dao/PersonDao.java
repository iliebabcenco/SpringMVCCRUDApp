package md.babcenco.springcourse.dao;

import md.babcenco.springcourse.models.Person;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDao {

    private static final String URL = "jdbc:postgresql://localhost:5432/first.db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "lploli22";
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public List<Person> index() {
        List<Person> personList = new ArrayList<>();
        String sql = "SELECT * FROM Person;";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setSurname(rs.getString("surname"));
                person.setAge(rs.getInt("age"));
                person.setEmail(rs.getString("email"));
                personList.add(person);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return personList;
    }

    public Person showPerson(int id) {
        String sql = "SELECT * FROM Person WHERE id=?;";
        Person person = new Person();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setSurname(rs.getString("surname"));
            person.setAge(rs.getInt("age"));
            person.setEmail(rs.getString("email"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return person;
    }

    public void addPerson(Person person) {
        String sql = "INSERT INTO Person VALUES(?, ?, ?, ?, ?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, person.getId());
            st.setString(2, person.getName());
            st.setString(3, person.getSurname());
            st.setInt(4, person.getAge());
            st.setString(5, person.getEmail());
            st.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void update(int id, Person person) {
        String sql = "UPDATE Person SET name=?, surname=?, age=?, email=? WHERE id=" + id + ";";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, person.getName());
            st.setString(2, person.getSurname());
            st.setInt(3, person.getAge());
            st.setString(4, person.getEmail());
            st.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {
        Person persontToBeDeleted = showPerson(id);
        String sql = "DELETE FROM Person WHERE id=?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // people.remove(persontToBeDeleted);
    }
}
