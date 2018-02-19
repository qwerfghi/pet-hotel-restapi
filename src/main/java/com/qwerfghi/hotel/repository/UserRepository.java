package com.qwerfghi.hotel.repository;

import com.qwerfghi.hotel.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User getByUsernameAndPassword(String username, String password);
}