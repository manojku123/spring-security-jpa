package io.java.springsecurityjpa.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.java.springsecurityjpa.dto.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
Optional<User> findByUserName(String userName);
}
