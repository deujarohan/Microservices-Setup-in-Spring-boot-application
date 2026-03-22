package com.user.user_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.user_service.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {}
