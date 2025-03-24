package com.car_app.user_service.user_service.repo;

import com.car_app.user_service.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmailId(String email);

    @Override
    Optional<User> findById(Long aLong);
}