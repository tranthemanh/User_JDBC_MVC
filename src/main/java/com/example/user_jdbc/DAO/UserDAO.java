package com.example.user_jdbc.DAO;

import com.example.user_jdbc.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDAO implements IUserDAO {

    public static Connection getConnection() {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/user_jdbc";
        String user = "root";
        String password = "123456Abc";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Ket noi thanh cong");
        } catch (SQLException e) {
            System.out.println("Loi ket noi.");
            throw new RuntimeException(e);
        }
        return connection;
    }

    @Override
    public List<User> showAllUsers() {
        List<User> users = new ArrayList<User>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from user");) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String country = resultSet.getString("country");
                User user = new User(id, username, age, country);
                users.add(user);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public void createUser(User user) {
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into user"+"(name, age, country) value "+"(?, ?, ?)");){
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findById(int id) {
        User user = null;
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id=?");){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String country = resultSet.getString("country");
                user = new User(id, name, age, country);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<User> findByName(String nameFind) {
        List<User> users = new ArrayList<User>();
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user where name rlike ? COLLATE utf8mb4_general_ci");
        ){
            preparedStatement.setString(1, nameFind);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String country = resultSet.getString("country");
                User user = new User(id, name, age, country);
                users.add(user);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public User findByCountry(String country) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from user where country=?");){
            preparedStatement.setString(1, country);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                user = new User(id, name, age, country);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("update user set name = ?, age = ?, country = ? where id = ?");){
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("delete from user where id=?");
        ){
            preparedStatement.setInt(1,id);
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }

    @Override
    public List<User> SortByNameASC() {
        List<User> users = new ArrayList<User>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from user order by name asc");) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String country = resultSet.getString("country");
                User user = new User(id, username, age, country);
                users.add(user);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public List<User> SortByNameDESC() {
        List<User> users = new ArrayList<User>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from user order by name desc");) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String country = resultSet.getString("country");
                User user = new User(id, username, age, country);
                users.add(user);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public List<User> SortByAgeASC() {
        List<User> users = new ArrayList<User>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from user order by age asc");) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String country = resultSet.getString("country");
                User user = new User(id, username, age, country);
                users.add(user);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public List<User> SortByAgeDESC() {
        List<User> users = new ArrayList<User>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from user order by age desc");) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String country = resultSet.getString("country");
                User user = new User(id, username, age, country);
                users.add(user);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public List<User> SortByIdASC() {
        List<User> users = new ArrayList<User>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from user order by id asc");) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String country = resultSet.getString("country");
                User user = new User(id, username, age, country);
                users.add(user);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public List<User> SortByIdDESC() {
        List<User> users = new ArrayList<User>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from user order by id desc");) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String country = resultSet.getString("country");
                User user = new User(id, username, age, country);
                users.add(user);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

}
