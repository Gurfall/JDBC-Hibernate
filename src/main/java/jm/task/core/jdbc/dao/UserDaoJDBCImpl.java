package jm.task.core.jdbc.dao;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.*;

public class UserDaoJDBCImpl implements UserDao {

    Util util = new Util();

    public void createUsersTable() {
//        String createTableSQL = "CREATE TABLE Users " +
//                " (id SERIAL PRIMARY KEY, "
//                + "first_name VARCHAR(50), "
//                + "last_name VARCHAR(50), "
//                + "age INT"
//                + ");";
//
//        try (Connection connection = util.getConnection();
//             Statement statement = connection.createStatement()){
//            statement.executeUpdate(createTableSQL);
//        }
//        catch(SQLException ignored){
//
//        }
        try (Connection connection = util.getConnection()) {
            String SQL = "CREATE TABLE IF NOT EXISTS users (" +
                    "id SERIAL ," +
                    "name VARCHAR," +
                    "lastName VARCHAR," +
                    "age int" +
                    ")";

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void dropUsersTable() {
        String dropTableSQL = "DROP TABLE users";

        try (Connection connection = util.getConnection();
             Statement statement = connection.createStatement()){
            statement.executeUpdate(dropTableSQL);
        }
        catch(SQLException ignored){

        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String saveUserSQL ="INSERT INTO users (name, lastname, age) VALUES(?, ?, ?)" ;

        try (Connection connection = util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(saveUserSQL)){
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User с именем –" +name +" добавлен в базу данных");
        }
        catch(SQLException ignored){

        }

    }

    public void removeUserById(long id) {
        String removeUserSQL = "DELETE FROM users WHERE id = ?";

        try (Connection connection = util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(removeUserSQL)){
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
//
//        List<User> users = new ArrayList<>();
//        String getAllUsersSQL = "SELECT * FROM Users";
//
//        try (Connection connection = util.getConnection();
//             Statement statement = connection.createStatement();
//             ResultSet rs = statement.executeQuery(getAllUsersSQL)) {
//
//
//            while (rs.next()) {
//                String firstName = rs.getString("first_name");
//                String lastName = rs.getString("last_name");
//                byte age = (byte) rs.getInt("age");
//                users.add(new User(firstName,lastName,age));
//
//            }
//
//        } catch (SQLException ignored) {
//        }
//        finally {
//            return users;
//        }
//
//    }
        List<User> users = new ArrayList<>();

        try (Connection connection = util.getConnection()) {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));

                users.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }



    public void cleanUsersTable() {
        String cleanUsersTableSQL = "TRUNCATE Users";

        try (Connection connection = util.getConnection();
        Statement statement = connection.createStatement()){
            statement.executeUpdate(cleanUsersTableSQL);
        } catch (SQLException ignored) {

        }
    }
}
//Реализовать методы