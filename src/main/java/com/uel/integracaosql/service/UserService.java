package com.uel.integracaosql.service;

import com.uel.integracaosql.model.Users;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<Users> findAll();
    Optional<Users> findById(Long id);
    Users save(Users user);
    void deleteById(Long id);
}