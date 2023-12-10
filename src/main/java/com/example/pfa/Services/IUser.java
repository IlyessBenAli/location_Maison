package com.example.pfa.Services;

import com.example.pfa.Entites.User;

import java.util.List;

public interface IUser {
    List<User> getAll();

    void saveUser(User user);

    User getUserById(Long id);

    void deleteUser(Long id);

    User updateUser(Long id, User user);
}
