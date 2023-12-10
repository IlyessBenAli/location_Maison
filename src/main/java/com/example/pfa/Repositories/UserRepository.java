package com.example.pfa.Repositories;


import com.example.pfa.Entites.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
