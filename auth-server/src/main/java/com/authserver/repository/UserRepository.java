package com.authserver.repository;

import com.authserver.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

    public Boolean existsByEmail(String email);
    public Boolean existsByUserName(String userName);
    public User findByEmail(String email);
}
