package com.it_components_store.repository;

import com.it_components_store.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByAddress(String address);
    Optional<User> findUsersByEmail(String email);

}