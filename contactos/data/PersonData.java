package data;

import entities.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonData {
    Connection cn = ConnectionBD.connectSQLite();
    public void create(Person person) {
        String sql = " INSERT INTO users(name, age) "
                + " VALUES(?,?) ";
        int i = 0;
        int rsId = 0;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(++i, person.getName());
            ps.setInt(++i, person.getAge());
            rsId = ps.executeUpdate();
            System.out.println("rsId: " + rsId);
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
    public List<Person> list() {
        List<Person> list = new ArrayList<Person>();
        String sql = "SELECT * FROM users";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Person p = new Person();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setAge(rs.getInt("age"));
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return list;
    }
    public Person get(int id) {
        Person p = new Person();
        String sql = "SELECT * FROM users WHERE id = " + id + "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setAge(rs.getInt("age"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return p;
    }
    public void update(Person p) {
        String sql = " UPDATE users SET " +
                "name = ?, " +
                "age = ?" +
                "WHERE id = ? ";
        int i = 0;
        int rsId = 0;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(++i, p.getName());
            ps.setInt(++i, p.getAge());
            ps.setInt(++i, p.getId());
            rsId = ps.executeUpdate();
            System.out.println("update.rsId: " + rsId);
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
    public void delete(int id) {
        String sql = "DELETE FROM persons WHERE id = ?";
        int res =0;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id );
            res = ps.executeUpdate();
            System.out.println("delete.res=" + res);

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }
}
