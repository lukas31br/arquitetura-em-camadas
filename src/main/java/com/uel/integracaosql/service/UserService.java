package com.uel.integracaosql.service;

import com.uel.integracaosql.model.Users;
import java.util.List;

public interface UserService {
    List<Users> findAll();
    Users save(Users user);
}