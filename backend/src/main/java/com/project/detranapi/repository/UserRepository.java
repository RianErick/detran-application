package com.project.detranapi.repository;

import com.project.detranapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByLogin (String login);
}
