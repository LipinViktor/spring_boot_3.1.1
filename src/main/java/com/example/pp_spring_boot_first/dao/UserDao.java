package com.example.pp_spring_boot_first.dao;



import com.example.pp_spring_boot_first.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User findById(long id);

    void save(User user);

    void update(long id, User user);

    void delete(long id);

}
