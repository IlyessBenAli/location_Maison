package com.example.pfa.Services;
import com.example.pfa.Entites.User;
import com.example.pfa.Repositories.UserRepository;
import com.example.pfa.exceptions.ErrorStrings;
import com.example.pfa.exceptions.MyInternalServerErrorException;
import com.example.pfa.exceptions.MyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements  IUser {


    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }



    @Override
    public void saveUser(User user) {
        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.CLINT_NOT_FOUND));
    }

    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
    }

    public User updateUser(Long id, User user) {
        User userdb =  userRepository.findById(id).orElseThrow(() -> new MyNotFoundException(ErrorStrings.CLINT_NOT_FOUND));
        try {
            userdb.setAddress(user.getAddress());
            userdb.setEmail(user.getEmail());
            userdb.setNom(user.getNom());
            userdb.setNumTel(user.getNumTel());
            userRepository.save(userdb);
        } catch (Exception e) {
            throw new MyInternalServerErrorException();
        }
        return userdb;
    }

}
