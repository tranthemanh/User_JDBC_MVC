package com.example.user_jdbc.DAO;

import com.example.user_jdbc.model.User;

import java.util.List;

public interface IUserDAO {
    List<User> showAllUsers();

    void createUser(User user);

    User findById(int id);

    List<User> findByName(String name);

    User findByCountry(String country);

    boolean updateUser(User user);

    boolean deleteUser(int id);

    List<User> SortByNameASC();
    List<User> SortByNameDESC();
    List<User> SortByAgeASC();
    List<User> SortByAgeDESC();
    List<User> SortByIdASC();
    List<User> SortByIdDESC();

}
