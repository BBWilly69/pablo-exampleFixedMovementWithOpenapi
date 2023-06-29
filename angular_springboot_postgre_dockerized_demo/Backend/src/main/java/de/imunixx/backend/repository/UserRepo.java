package de.imunixx.backend.repository;

import de.imunixx.api.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    void deleteUserById(Long id);
    Optional<User> findUserById(Long id);
    Optional<User>  findUserByEmail(String email);
    Optional<User> findUserByEmailAndPassword(String email, String password);
    Optional<User> findUserByUserCode(String userCode);
}