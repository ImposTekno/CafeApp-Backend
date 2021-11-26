package com.ImposTekno.CafeApp.Repository;

import com.ImposTekno.CafeApp.Model.User;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Qualifier("users")
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Query method for deleting a user with specified 'id' form database
    void deleteUserById(Long id);

    // Query method for finding a user with specified 'id' in a database
    Optional<User> findUserById(Long id);
    Optional<User> findUserByfirstName(String name);
}
