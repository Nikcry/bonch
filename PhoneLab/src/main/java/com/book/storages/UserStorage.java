package com.book.storages;

import com.book.models.User;

import java.sql.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserStorage {
    private static final UserStorage instance = new UserStorage();

    private UserStorage() {
    }

    public static UserStorage getInstance(){
        return instance;
    }

    private Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/book?user=root&password=&" +
                "useJDBCCompliantTimezoneShift=true&" +
                "useLegacyDatetimeCode=false&" +
                "serverTimezone=UTC";
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertUser(User user) {
        try {
            Connection connection = getConnection();
            String query = "INSERT INTO users (name, phone) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPhone());
            statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            Connection connection = getConnection();
            String query = "UPDATE users set name = ?, phone = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPhone());
            statement.setInt(3, user.getId());
            statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try {
            Connection connection = getConnection();
            String query = "DELETE FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> result = new CopyOnWriteArrayList<>();
        try {
            Connection connection = getConnection();
            String query = "SELECT * FROM users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setPhone(resultSet.getString(3));
                result.add(user);
            }
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}